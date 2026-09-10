class Solution {
    String[] ones = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder ans = new StringBuilder();

        if (num >= 1_000_000_000) {
            ans.append(convert(num / 1_000_000_000))
               .append(" Billion");
            num %= 1_000_000_000;
        }

        if (num >= 1_000_000) {
            addSpace(ans);
            ans.append(convert(num / 1_000_000))
               .append(" Million");
            num %= 1_000_000;
        }

        if (num >= 1000) {
            addSpace(ans);
            ans.append(convert(num / 1000))
               .append(" Thousand");
            num %= 1000;
        }

        if (num > 0) {
            addSpace(ans);
            ans.append(convert(num));
        }

        return ans.toString();
    }

    private String convert(int num) {
        StringBuilder ans = new StringBuilder();

        if (num >= 100) {
            ans.append(ones[num / 100])
               .append(" Hundred");
            num %= 100;
        }

        if (num >= 20) {
            addSpace(ans);
            ans.append(tens[num / 10]);
            num %= 10;
        }

        if (num > 0) {
            addSpace(ans);
            ans.append(ones[num]);
        }

        return ans.toString();
    }

    private void addSpace(StringBuilder sb) {
        if (sb.length() > 0) {
            sb.append(" ");
        }
    }
}