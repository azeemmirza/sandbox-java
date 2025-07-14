package lab_09.problem_statement;

import lab_09.problem_statement.Expr;

public record Add(Expr left, Expr right) implements Expr {}
