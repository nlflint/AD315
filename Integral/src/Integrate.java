/* Program to approximate the value of 
 * a definite integral. User will pass
 * an interval, number of approximating 
 * rectangles, and method of integration
 */


import java.util.stream.IntStream;

public class Integrate {
    public final double ApproximateValue;

    // Constructor
    Integrate(String str, double a, double b, int n) {
        Problem problem = new Problem(str, a, b, n);
        ApproximateValue = Solve(problem);
    }

    private double Solve(Problem problem) {
        double sum = IntStream
                .range(problem.IntervalStart, problem.IntervalEnd)
                .mapToDouble(i -> evaluate(problem.LowerBound + (i * problem.Delta)))
                .sum();

        if (problem.IsTrapezoidal)
            return ((sum * 2) + evaluate(problem.LowerBound) + evaluate(problem.UpperBound))
                    * problem.Delta / 2;
        else
            return sum * problem.Delta;
    }

    // method to evaluate a function
    private double evaluate(double x) {
        return Math.pow(x,2);
    }

    // the main method
    public static void main(String[] args) {
        String approximationMethod = args[0];
        double lowerBound = Double.parseDouble(args[1]);
        double upperBound = Double.parseDouble(args[2]);
        int numberOfRectangles = Integer.parseInt(args[3]);

        String ruleName = getApproximationMethodName(approximationMethod);
        String summary = String.format("You are integrating over the interval (%s,%s) using %s rule and %d rectangles.",
                lowerBound,
                upperBound,
                ruleName,
                numberOfRectangles);
        System.out.println(summary);

        Integrate integrator = new Integrate(approximationMethod, lowerBound, upperBound, numberOfRectangles);
        System.out.println(String.format("Approximate value: %s", integrator.ApproximateValue));

        double actualValue = getActualValue(lowerBound, upperBound);
        System.out.println(String.format("Actual value: %s", actualValue));

        double absoluteError = Math.abs(integrator.ApproximateValue - actualValue);
        System.out.println(String.format("Absolute error: %s", absoluteError));

        double relativeError = absoluteError / Math.abs(actualValue);
        System.out.println(String.format("Relative error: %s", relativeError));
    }

    private static String getApproximationMethodName(String approximationMethod) {
        if (approximationMethod.equals("l"))
            return "left handed";
        if (approximationMethod.equals("r"))
            return "right handed";
        return "trapezoid";
    }

    private static double getActualValue(double lowerBound, double upperBound) {
        return (Math.pow(upperBound,3) / 3) - (Math.pow(lowerBound,3) / 3);
    }

    private class Problem {
        final int IntervalStart;
        final int IntervalEnd;
        final double Delta;
        final double LowerBound;
        final double UpperBound;
        final boolean IsTrapezoidal;

        Problem(String str, double a, double b, int n) {
            IntervalStart =  str.equals("l") ? 0 : 1;
            IntervalEnd = str.equals("r") ? n + 1 : n;
            IsTrapezoidal = str.equals("t");
            Delta = (b - a) / n;
            LowerBound = a;
            UpperBound = a + (n * Delta);


        }
    }
}