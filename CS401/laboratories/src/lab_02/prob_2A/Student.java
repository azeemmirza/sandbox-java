package lab_02.prob_2A;

public class Student {
    private String name;
    private GradeReport report;

    public Student(String name) {
        this.name = name;
        this.report = new GradeReport(this);
    }
}
