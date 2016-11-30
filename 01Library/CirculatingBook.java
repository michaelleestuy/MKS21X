public class CirculatingBook extends LibraryBook{

     /**
     * field for currentHolder
     */
    private String currentHolder;

    /**
     * Getter for currentHolder.
     * @return value of currentHolder
     */
    public String getCurrentHolder(){
	return currentHolder;
    }

    /**
     * Setter for currentHolder
     * @param s desired value of currentHolder
     */
    public void setCurrentHolder(String s){
	currentHolder = s;
    }

     /**
     * field for dueDate
     */
    private String dueDate;

    /**
     * Getter for dueDate
     * @return value of dueDate
     */
    public String getDueDate(){
	return dueDate;
    }

    /**
     * Setter for dueDate
     * @param s desired value of dueDate
     */
    public void setDueDate(String s){
	dueDate = s;
    }

    /**
     * Constructor for author, title, ISBN, call number
     * leaves currentHolder and dueDate null
     * @param a the String for author
     * @param t the String for title
     * @param n the String for ISBN
     * @param c the String for callNumber
     */
    public CirculatingBook(String a, String t, String n, String c){
	super(a, t, n, c);
    }
    
    /**
     * Sets currentHolder and dueDate to the respectiive values
     * @param patron the new currentHolder
     * @param due the new dueDate
     */
    public void checkout(String patron, String due){
	setCurrentHolder(patron);
	setDueDate(due);
    }

    /**
     * Sets currentHolder and dueDate back to null
     */
    public void returned(){
	setCurrentHolder(null);
	setDueDate(null);
    }

    /**
     * Returns the current status of the book
     * @return "book available on shelves" if book is not checked out, and currentHolder, dueDate if it is checked out
     */
    public String circulationStatus(){
	if(currentHolder == null){
	    return "book available on shelves";
	}
	else{
	    return getCurrentHolder() + ", " + getDueDate();
	}
    }

    public static void main(String[]args){
	CirculatingBook a = new CirculatingBook("Farm", "Orwell", "12", "Call911");
	System.out.println(a);
	System.out.println(a.circulationStatus());
	a.checkout("Bob", "Never");
	System.out.println(a.circulationStatus());
	a.returned();
	System.out.println(a.circulationStatus());
    }
}
