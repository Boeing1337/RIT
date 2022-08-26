package body;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Sample {
    private static String input = "<note> <to> Tove </to>    <to>Tove2</to><to>Tove3</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
    private static Deque<String> prefixes = new ArrayDeque<>();
    private static Deque<String> result = new ArrayDeque<>();

    public static void main(String[] args) {
        moveSuffixPartToPrefix(input.indexOf(">") + 1);

        while (!prefixes.isEmpty() && !input.isEmpty()) {

            if (input.startsWith("</")) {
                var body = "";
                var closingSuffix = input.substring(0, input.indexOf(">") + 1);
                var neededPrefix = "<" + closingSuffix.substring(2);
                var prefixCandidate = "";

                while (!Objects.equals(prefixCandidate = prefixes.pollLast(), neededPrefix)) {
                    body = prefixCandidate + body;
                }

                result.add(body);
                prefixes.add(prefixCandidate + body + closingSuffix);
                input = input.substring(closingSuffix.length());
            } else if (input.startsWith("<")) {
                moveSuffixPartToPrefix(input.indexOf(">") + 1);
            } else {
                moveSuffixPartToPrefix(input.indexOf("<"));
            }

        }

        result.forEach(System.out::println);
    }

    private static void moveSuffixPartToPrefix(int lastIndex) {
        var newPrefix = input.substring(0, lastIndex);
        prefixes.add(newPrefix);
        input = input.substring(newPrefix.length());
    }

    @Override
    public String toString() {
        return "class name";
    }
}


