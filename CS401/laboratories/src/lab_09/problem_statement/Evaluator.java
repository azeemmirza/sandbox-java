package lab_09.problem_statement;

import lab_09.problem_statement.Add;
import lab_09.problem_statement.Constant;
import lab_09.problem_statement.Expr;
import lab_09.problem_statement.Multiply;

public class Evaluator {
    public static int eval(Expr expr) {
        return switch (expr) {
            case Constant c -> c.value();
            case Add a -> eval(a.left()) + eval(a.right());
            case Multiply m -> eval(m.left()) * eval(m.right());
        };
    }
}
