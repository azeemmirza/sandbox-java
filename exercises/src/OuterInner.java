public class OuterInner {
    private MyInner inner;

    public MyInner getInner() {
        return inner;
    }

    private class MyInner {
        private int innerInt;

        MyInner(int x) {
            innerInt = x;
        }
    }
}
