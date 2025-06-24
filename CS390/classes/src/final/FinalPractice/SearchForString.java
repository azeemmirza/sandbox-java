public class SearchForString {
    private String[] arr;

    public SearchForString(String[] arr) {
        this.arr = arr;
    }

    public boolean search(String s) {
        return recurSearch(s, arr.length);
    }

    private boolean recurSearch(String s, int upperIndex) {
        if (upperIndex == 0) return false;
        if (arr[upperIndex - 1].equals(s)) return true;
        return recurSearch(s, upperIndex - 1);
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "date", "fig"};
        SearchForString searcher = new SearchForString(words);

        System.out.println(searcher.search("banana")); // true
        System.out.println(searcher.search("grape"));  // false
        System.out.println(searcher.search("fig"));    // true
    }
}