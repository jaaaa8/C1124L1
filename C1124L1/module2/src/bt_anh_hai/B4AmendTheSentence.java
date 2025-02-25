package bt_anh_hai;

public class B4AmendTheSentence {
    public static String amendTheSentence(String sentence) {
        StringBuilder sb = new StringBuilder();
        char[] chars = sentence.toCharArray();
        int count = 0;
        for(int i = 0;i < chars.length;i++) {
            if(Character.isUpperCase(chars[i])) {
                sb.append(Character.toLowerCase(chars[i]));
                if(i != 0) {
                    sb.insert(i + count, ' ');
                    count++;
                }
            }else sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "CodeGymDaNang";
        System.out.println(amendTheSentence(s));
    }
}
