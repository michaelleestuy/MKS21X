abstract class LibraryBook extends Book implements Comparable<LibraryBook>{

    /**
     * field for callNumber
     */
    private String callNumber;

    /**
     * Getter for callNumber.
     * @return value of callNumber
     */
    public String getCallNumber(){
	return callNumber;
    }

    /**
     * Setter for callNumber.
     * @param s desired value of callNumber
     */
    public void setCallNumber(String s){
	callNumber = s;
    }
    
    /**
     * Constructor for author, title, ISBN, call number
     * @param a the String for author
     * @param t the String for title
     * @param n the String for ISBN
     * @param c the String for callNumber
     */
    public LibraryBook(String a, String t, String n, String c){
	setAuthor(a);
	setTitle(t);
	setISBN(n);
	setCallNumber(c);
    }

    abstract void checkout(String patron, String due);

    abstract void returned();

    abstract String circulationStatus();

    /**
     * Comparing LibraryBooks based on callNumber
     * @param b book being compared to
     * @return positive if object comes first, negative if parameter comes first, 0 if same spot
     */
    public int compareTo(LibraryBook b){
	return (b.getCallNumber()).compareTo(getCallNumber());
    }

    /**
     * title, author, ISBN, callNumber
     * @return title, author, ISBN, callNumber
     */
    public String toString(){
	return super.toString() + ", " + getCallNumber();
    }

   
}
