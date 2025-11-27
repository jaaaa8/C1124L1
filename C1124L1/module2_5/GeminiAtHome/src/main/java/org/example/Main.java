package org.example;

import com.google.gson.*;
import okhttp3.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final String MODEL = "gemini-2.5-flash";
    private static final String URL =
            "https://generativelanguage.googleapis.com/v1beta/models/" + MODEL + ":generateContent";

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .build();
    private static final Gson gson = new GsonBuilder().create();

    public static void main(String[] args) throws IOException {
        String apiKey = System.getenv("GEMINI_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            System.err.println("❌ Chưa đặt biến môi trường GEMINI_API_KEY!");
            System.err.println("Cách đặt:");
            System.err.println("Windows PowerShell:   $env:GEMINI_API_KEY=\"your_api_key\"");
            System.err.println("Mac/Linux Terminal:   export GEMINI_API_KEY=your_api_key");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gemini Chatbot ===");
        System.out.println("Nhập 'exit' để thoát.");

        while (true) {
            System.out.print("\nBạn: ");
            String user = scanner.nextLine();
            if (user == null || user.equalsIgnoreCase("exit")) break;
            if (user.isBlank()) continue;

            try {
                String reply = sendPrompt(apiKey, user);
                System.out.println("Gemini: " + reply);
            } catch (Exception e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static String sendPrompt(String apiKey, String promptText) throws IOException {
        JsonObject textPart = new JsonObject();
        textPart.addProperty("text", promptText);

        JsonArray parts = new JsonArray();
        parts.add(textPart);

        JsonObject content = new JsonObject();
        content.add("parts", parts);

        JsonArray contents = new JsonArray();
        contents.add(content);

        JsonObject body = new JsonObject();
        body.add("contents", contents);

        RequestBody requestBody = RequestBody.create(
                body.toString(),
                MediaType.get("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(URL)
                .addHeader("x-goog-api-key", apiKey)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("HTTP " + response.code() + ": " + response.message());

            String json = response.body() != null ? response.body().string() : "{}";
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            try {
                return obj.getAsJsonArray("candidates")
                        .get(0).getAsJsonObject()
                        .getAsJsonObject("content")
                        .getAsJsonArray("parts")
                        .get(0).getAsJsonObject()
                        .get("text").getAsString();
            } catch (Exception e) {
                return json;
            }
        }
    }
}
