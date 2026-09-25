class Solution {

    private String s;
    private int index;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;

        Set<String> result = parseExpression();

        return new ArrayList<>(result);
    }

    // Handles union: A,B,C
    private Set<String> parseExpression() {
        Set<String> result = parseTerm();

        while (index < s.length() && s.charAt(index) == ',') {
            index++;
            result.addAll(parseTerm());
        }

        return result;
    }

    // Handles concatenation: AB, A{b,c}, etc.
    private Set<String> parseTerm() {
        Set<String> result = new TreeSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != '}'
                && s.charAt(index) != ',') {

            Set<String> next;

            if (s.charAt(index) == '{') {
                index++;
                next = parseExpression();
                index++; // skip '}'
            } else {
                next = new TreeSet<>();
                next.add(String.valueOf(s.charAt(index)));
                index++;
            }

            Set<String> combined = new TreeSet<>();

            for (String a : result) {
                for (String b : next) {
                    combined.add(a + b);
                }
            }

            result = combined;
        }

        return result;
    }
}