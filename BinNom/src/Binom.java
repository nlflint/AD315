import java.util.Date;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Calculates binomial coefficients from pascal's triangle in three different ways using integers:
 *
 * 1: Compact form
 *  This method can't calculate anything over N = 12. Any greater value of N has errors in the
 *  result. The factorials get too big! It's also the slowest method of the three.
 *
 * 2: Multiplicative formula
 *  This method is also limited to N = 12, after which there are errors, but it is a lot faster than method1.
 *
 * 3: Recursively
 *   This method is the fastest of the three (for N <= 12), and can go to to much greater values of N.
 *   It is the best choice. For larger values of N this method slows down significantly, and the other 2
 *   methods perform faster. However, in those cases, the other two methods are filled with errors.
 */
public class Binom {
    public static void main(String[] args) {
        Binom binom = new Binom();
        binom.Start();
    }

    private void Start() {
        int n = 12;
        profileMethod(Method.One, n);
        profileMethod(Method.Two, n);
        profileMethod(Method.Three, n);
    }

    private void profileMethod(Method method, int n) {
        Date start = new Date();
        IntBinaryOperator operator = getOperatorFromMethod(method);

        System.out.println(
                String.format("Method %s for N=%s: \t", method.toString(), n) +
                        calculateCoefficients(operator, n));
        System.out.println(
                String.format("Method %s took: \t\t%sms \n"
                        , method.toString()
                        , (new Date().getTime() - start.getTime())));
    }

    private IntBinaryOperator getOperatorFromMethod(Method method) {
        switch (method) {
            case One:
                return this::method1;
            case Two:
                return this::method2;
            default:
                return this::method3;
        }
    }

    public List<Integer> calculateCoefficients(IntBinaryOperator operator, int n) {
        return IntStream
                .range(0,n + 1)
                .map(x -> operator.applyAsInt(n,x))
                .boxed()
                .collect(Collectors.toList());
    }

    public int method1(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));

    }

    public int factorial(int x) {
        if (x == 0)
            return 1;
        return recursiveFactorial(1, x);
    }

    private int recursiveFactorial(int totalValue, int x) {
        if (x == 0)
            return totalValue;
        return recursiveFactorial(totalValue * x, x - 1);
    }

    public int method2(int n, int k) {
        return numerator(n,k) / factorial(k);
    }

    private int numerator(int n, int k) {
        return IntStream
                .range(0, k)
                .map(x -> n - x)
                .reduce(1, (x,y) -> x * y);
    }

    public int method3(int n, int k) {
        if (k == 0 || n == k)
            return 1;
        return method3(n - 1, k) + method3(n - 1, k - 1);
    }

    private enum Method {
        One,
        Two,
        Three
    }


}
