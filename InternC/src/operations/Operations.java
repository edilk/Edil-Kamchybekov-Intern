package operations;

public class Operations {

    public double add(double x, double y) {
        Calculate addition = (Double::sum);
        return addition.calculate(x, y);
    }

    public double subtract(double x, double y) {
        Calculate subtraction = (x1, y1) -> x1 - y1;
        return subtraction.calculate(x, y);
    }

    public double multiply(double x, double y) {
        Calculate multiplication = (x1, y1) -> x1 * y1;
        return multiplication.calculate(x, y);
    }

    public double divide(double x, double y) {
        Calculate division = (x1, y1) -> {
            if (y1 == 0) {
                throw new IllegalArgumentException("Division by zero!");
            }

            return x1 / y1;
        };
        return division.calculate(x, y);
    }
}
