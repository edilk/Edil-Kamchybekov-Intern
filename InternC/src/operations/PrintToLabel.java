package operations;

import java.util.ArrayList;
import java.util.List;

public class PrintToLabel {
    Operations operations = new Operations();

    public String printAdditionAndSubtraction(double x, double y, String operator) {
        operations = new Operations();
        double result = operator.equals("+") ? operations.add(x, y) : operations.subtract(x, y);

        return "<html>\n" +
                "<body>\n" +
                "\t<table>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"1%\" rowspan=\"2\" align=\"center\">" + operator + "</td>\n" +
                "\t\t\t<td>" + x + "</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>" + y + "</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"1%\" colspan=\"2\"><hr></td>\n" +
                "\t\t</tr>" +
                "\t\t<tr>\n" +
                "\t\t\t<td width=\"1%\" colspan=\"2\" align=\"right\">" + result + "</td>\n" +
                "\t\t</tr>" +
                "\t</table>\n" +
                "</body>\n" +
                "</html>";
    }

    public String printDivision(double x, double y) {

        if (y == 0) {
            return "Division by zero!";
        }

        double result = operations.divide(x, y);

        int first = (int) x;
        int second = (int) y;


        StringBuilder html = new StringBuilder("<html><body>\n" +
                "\t<table width=\"100%\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>" + x + "</td>\n" +
                "\t\t\t<td>|</td>\n" +
                "\t\t\t<td>" + y + "</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td></td>\n" +
                "\t\t\t<td colspan=\"2\"><hr></td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td><hr></td>\n" +
                "\t\t\t<td>|</td>\n" +
                "\t\t\t<td>" + result + "</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>" +
                "\t\t\t<td>" + result + "</td>" +
                "\t\t</tr>" +
                "\t</table>\n" +
                "</body></html>");

        return html.toString();
    }

    public String printMultiplication(double x, double y) {
        double result = operations.multiply(x, y);

        int count = 0;

        List<Integer> digits = new ArrayList<>();
        String str = String.valueOf(y);
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                digits.add(Integer.parseInt(String.valueOf(str.charAt(i))));
            }
        }
        String top = String.valueOf(x).replace(".", "");
        int newX = Integer.parseInt(top);

        for (int i = str.indexOf(".") + 1; i < str.length(); i++) {
            count++;
        }

        for (int i = top.indexOf(".") + 1; i < top.length(); i++) {
            count++;
        }

        String res = String.format("%."+ count +"f", result);

        StringBuilder html = new StringBuilder("<html>" +
                "<body>\n" +
                "\t<table width=\"100%\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td rowspan=\"2\">*</td>" +
                "\t\t\t<td colspan=\"2\">" + x + "</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"2\">" + y + "</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"2\"><hr></td>\n" +
                "\t\t</tr>\n");

        StringBuilder white = new StringBuilder(" ");
        for (Integer digit : digits) {
            html.append("\t\t<tr>\n" + "\t\t\t<td>")
                    .append("\t\t\t</td><td align=\"center\">")
                    .append(digit * newX).append(white).append("</td>\n")
                    .append("\t\t</tr>\n");
            white.append(" ");
        }
        html.append("\t\t<tr>" + "\t\t\t<td colspan=\"2\"><hr></td>" + "\t\t</tr>" + "\t\t<tr><td></td>" + "\t\t\t<td>")
                .append(res).append("</td>").append("\t\t</tr>").append("\t</table>\n")
                .append("</body>\n").append("</html>");

        return html.toString();
    }
}
