package lab_09.problem_statement;

public class Main {
    public static void main(String[] args) {

        Expr expr = new Multiply(
                new Add(new Constant(2), new Constant(3)),
                new Constant(4)
        );

        int result = Evaluator.eval(expr);
        System.out.println("Result is: " + result);
    }

}
