package projava;

public class RemoveDuplicate {
    public static void main(String[] args) {
        var data = "abcccbaabcc";

        var builder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (i > 0 && c == data.charAt(i - 1)) {
                continue;
            }
            builder.append(c);
        }
        var result = builder.toString();
        System.out.println(data);
        System.out.println(result);
    }
}
