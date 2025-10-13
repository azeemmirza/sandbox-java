package lab_09.problem_statement;

import lab_09.problem_statement.Add;
import lab_09.problem_statement.Constant;
import lab_09.problem_statement.Multiply;

public sealed interface Expr permits Constant, Add, Multiply {}

