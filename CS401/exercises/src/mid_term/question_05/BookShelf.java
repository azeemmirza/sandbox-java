package mid_term.question_05;

import java.util.*;

public class BookShelf {
  private final ArrayList<String> books;

    public BookShelf() {
      this.books = new ArrayList<String>();
    }
    
    public void addBook(String book) {
      this.books.add(book);
    }

    public String removeBook() {
      int size = this.books.size();
      String last = this.books.remove(size  - 1);

      return last;
    }
}
