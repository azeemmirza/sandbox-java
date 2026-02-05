package interfaces;

public class Main {
    public static void main(String[] args) {
        ComicBook comic = new Marvel();
        Marvel m = new Marvel();

        // is in interface
        comic.interfaceAbstractMethod();
        comic.print();

        // compile error, cannot use class only methods
        // comic.classMethod();

        // is not in interface
        m.classMethod();
    }
}
