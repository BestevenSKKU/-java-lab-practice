import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class OutOfRangeException extends Exception {
    OutOfRangeException(String msg) {
        super(msg);
    }
}

class AddZeroException extends Exception {
    AddZeroException(String msg) {
        super(msg);
    }
}

class SubtractZeroException extends Exception {
    SubtractZeroException(String msg) {
        super(msg);
    }
}

class Calculator {
    private int a, b;
    private char op;
    Calculator() {}
    Calculator(String expression) throws OutOfRangeException, AddZeroException, SubtractZeroException {
        split(expression);
        if (op == '+') {
            System.out.println(sum());
        }
        else if (op == '-') {
            System.out.println(sub());
        }
    }

    private void split(String expression) {
        Pattern pattern = Pattern.compile("(\\d+)([+|-])(\\d+)");
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()) {
            a = Integer.parseInt(matcher.group(1));
            b = Integer.parseInt(matcher.group(3));
            op = matcher.group(2).toCharArray()[0];
        }
    }

    private int sum() throws OutOfRangeException, AddZeroException {
        if (this.a == 0 || this.b == 0) {
            throw new AddZeroException("AddZeroException");
        }
        else if (this.a < 0 || 1000 < this.a || this.b < 0 || 1000 < this.b || this.a + this.b < 0 || 1000 < this.a + this.b) {
            throw new OutOfRangeException("OutOfRangeException");
        }
        else {
            return this.a + this.b;
        }
    }

    private int sub() throws OutOfRangeException, SubtractZeroException {
        if (this.a == 0 || this.b == 0) {
            throw new SubtractZeroException("SubtractZeroException");
        }
        else if (this.a < 0 || 1000 < this.a || this.b < 0 || 1000 < this.b || this.a - this.b < 0 || 1000 < this.a - this.b) {
            throw new OutOfRangeException("OutOfRangeException");
        }
        else {
            return this.a - this.b;
        }
    }
}
public class SimpleCalculator {
    public static void main(String[] args) throws OutOfRangeException, AddZeroException, SubtractZeroException {
        Scanner sc = new Scanner(System.in);

        Calculator calc = new Calculator(sc.nextLine());
    }
}
