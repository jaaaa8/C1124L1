package org.example;

import okhttp3.*;
import com.google.gson.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String API_URL = "http://localhost:11434/api/chat";
    private static final String MODEL = "aya:8b";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
                .writeTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
                .readTimeout(120, java.util.concurrent.TimeUnit.SECONDS)
                .build();

        Scanner scanner = new Scanner(System.in);

        System.out.println("🤖 Local Chatbot (Ollama + Java)");
        System.out.println("Gõ 'exit' để thoát.");

        while (true) {
            System.out.print("Bạn: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) break;

            JsonObject json = getJsonObject(userInput);

            RequestBody body = RequestBody.create(
                    json.toString(),
                    MediaType.parse("application/json")
            );

            Request request = new Request.Builder()
                    .url(API_URL)
                    .post(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    System.out.println("❌ Lỗi: " + response);
                    continue;
                }

                String responseBody = response.body().string();
                JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();

                // ✅ Ollama trả về: { "message": { "role": "...", "content": "..." }, ... }
                JsonObject messageObj = jsonResponse.getAsJsonObject("message");
                String reply = messageObj.get("content").getAsString();

                System.out.println("Bot: " + reply.trim());
            }
        }

        scanner.close();
    }

    @NotNull
    private static JsonObject getJsonObject(String userInput) {
        JsonObject json = new JsonObject();
        json.addProperty("model", MODEL);

        JsonArray messages = new JsonArray();

        JsonObject system = new JsonObject();
        system.addProperty("role", "system");
        system.addProperty("content", "Bạn là một trợ lý AI nói tiếng Việt, trả lời ngắn gọn và tự nhiên.");
        messages.add(system);

        JsonObject message = new JsonObject();
        message.addProperty("role", "user");
        message.addProperty("content", userInput);
        messages.add(message);

        json.add("messages", messages);
        json.addProperty("stream", false); // ⚡ quan trọng: tắt stream
        return json;
    }
}
