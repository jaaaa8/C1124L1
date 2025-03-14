package bt_anh_hai;


public class B6FindChar {
    public static char[] findDuplicateChar(String input) {
        StringBuilder str = new StringBuilder();
        for(int i = 0;i < input.length()-1;i++) {
            for(int j = i+1;j < input.length();j++) {
                if(input.charAt(i) == input.charAt(j)) {
                    str.append(input.charAt(i));
                }
            }
        }
        String result = removeDuplicates(str.toString());
        return result.toCharArray();
    }
    public static String removeDuplicates(String s) {
        return B2CommonCharacterCount.removeDuplicates(s);
    }
    public static void outputArray(char[] arr) {
        System.out.println("Mảng này có: ");
        for (char i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String input = "abdceffecdba";
        char[] arr = findDuplicateChar(input);
        outputArray(arr);
    }
}
