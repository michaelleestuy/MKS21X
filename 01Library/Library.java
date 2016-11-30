import java.util.ArrayList;
import java.util.Collections;

public class Library {
	ArrayList<LibraryBook> bookList;
  public Library () {
		bookList = new ArrayList<LibraryBook> ();
	}

	/**
	 * adds the given book to the library
	 * @param book
	 */
	public void addBook (LibraryBook book) {
		bookList.add(book);
	}

	/**
	 * prints all books in the library
	 */
	public void printLibrary () {
		System.out.println ("\nListing of books in the library\n");
		for (LibraryBook book: bookList)
			System.out.println (book);
		System.out.println ("End of book listing\n");
	}

	/**
	 * locates a book in the library
	 * @param book book being search in the library
	 * @return book object if book is found
	 *         null otherwise
	 */
	public LibraryBook findBook (LibraryBook book) {
		int index = Collections.binarySearch(bookList, book);
		if (index >= 0)
			return bookList.get(index);
		else
			return null;
	}

	/**
	 * sort books in the library by call number
	 */
	public void sortLibrary () {
		Collections.sort(bookList);
	}

	/**
	 * performs processing for checking a book out of the library
	 * @param patron  person checking out book
	 * @param dueDate date book is due to be returned
	 * @param callNum call number of book
	 */
	public void checkout (String patron, String dueDate, String callNum) {
		LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
		LibraryBook book = findBook(searchItem);
		if (book == null)
				System.out.println ("Book " + callNum + " not found -- checkout impossible\n");
		else
				book.checkout (patron, dueDate);
	}

	/**
	 * processes checked-out book that is being returned
	 * @param callNum call number of book being returned
	 */
	public void returned (String callNum) {
		LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
		LibraryBook book = findBook(searchItem);
		if (book == null)
			System.out.println ("Book " + callNum + " not found -- return impossible\n");
		else
			book.returned ();
	}










	/**
	 * main testing program
	 * @param args  not used
	 */
	public static void main (String args[]) {

		Library lib = new Library ();

		// set up library
		lib.addBook(new ReferenceBook("Ur Mom", "Ur Life", "ISBN:10101010101", "CallNumber: 102.192", "Ur House"));
		lib.addBook(new ReferenceBook("Ur Dad", "Ur Lives", "ISBN:10101010102", "CallNumber: 102.193", "Ur Room"));
		lib.addBook(new ReferenceBook("Ur Cat", "Ur Childhood", "ISBN:10101010103", "CallNumber: 102.194", "Ur House's House'"));

		lib.addBook(new CirculatingBook("Michael Lee", "Eugene's Life'", "ISBN:199", "CallNumber: 222.192"));
		lib.addBook(new CirculatingBook("Michael ShLee", "ShEugene's Life'", "ISBN:1991", "CallNumber: 222.193"));
		lib.addBook(new CirculatingBook("ShMichael Lee", "Eugene's ShLife'", "ISBN:1992", "CallNumber: 222.194"));

		// sort books by call number
		lib.sortLibrary();

		// print library
		lib.printLibrary();

		// some users check out and return books
		lib.checkout("Henry Thoreau", "Tomorrow", "CallNumber: 102.193");
		lib.checkout("Emerson Henry Thoreau", "Day After Tomorrow", "CallNumber: 222.193");
		lib.checkout("Emerson Henry Thoreau Ralph", "Day After Day After Tomorrow", "CallNumber: 222.194");
		lib.returned("CallNumber: 222.193");


		// print final status of library
		lib.printLibrary();
	}
}
