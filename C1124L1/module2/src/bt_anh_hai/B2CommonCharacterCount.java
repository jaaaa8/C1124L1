package bt_anh_hai;

public class B2CommonCharacterCount {
    public static int countCommonCharacters(String a, String b) {
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            for(int j = 0; j < b.length(); j++) {
                if(a.charAt(i) == b.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static String removeDuplicates(String s) {
        for(int i = 0;i < s.length() - 1;i++) {
            for(int j = i+1;j < s.length();j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    s = removeCharAt(s,j);
                    --j;
                }
            }
        }
        return s;
    }
    public static String removeCharAt(String str, int index) {
        if (index < 0 || index >= str.length()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(index);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "Abcdef1234";
        String s2 = "Uykhldg1";
        System.out.println(countCommonCharacters(removeDuplicates(s1), removeDuplicates(s2)));
    }
}
