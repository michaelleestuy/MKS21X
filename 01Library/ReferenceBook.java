public class ReferenceBook extends LibraryBook{

     /**
     * field for collection
     */
    private String collection;

    /**
     * Getter for collection.
     * @return value of collection
     */
    public String getCollection(){
	return collection;
    }

    /**
     * Setter for collection.
     * @param s desired value of collection
     */
    public void setCollection(String s){
	collection = s;
    }

    /**
     * Constructor for ReferenceBook
     * @param a value for author
     * @param t value for title
     * @param n value for ISBN
     * @param c value for callNumber
     * @param l value for collection
     */
    public ReferenceBook(String a, String t, String n, String c, String l){
	super(a, t, n, c);
	setCollection(l);
    }

    /**
     * Cannot checkout a reference book
     */
    public void checkout(String patron, String due){
	System.out.println("cannot check out a reference book");
    }
    
    /**
     * Returns the circulation of the book
     * @return "non-circulating reference book"
     */
    public String circulationStatus(){
	return "non-circulating reference book";
    }
    
    /**
     * Cannot return a reference book
     */
    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
    }
    
    /**
     * title, author, ISBN, callNumber, collection
     * @return title, author, ISBN, callNumber, collection
     */
    public String toString(){
	return super.toString() + ", " + getCollection();
    }

    public static void main(String[]args){
	ReferenceBook a = new ReferenceBook("Animal Farm", "Orwell", " Dewey Decimal", "What's a call number", "What's a collection");
	System.out.println(a);
	System.out.println(a.circulationStatus());
	a.returned();
	a.checkout("patron", "due");
    }
}
