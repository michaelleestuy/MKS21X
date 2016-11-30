public class Book{

    /**
     * Author's name.
     */
    private String author;

    /**
     * Getter for author.
     * @return value for author
     */
    public String getAuthor(){
	return author;
    }

    /**
     * Setter for author.
     * @param s desired author
     */
    public void setAuthor(String s){
	author = s;
    }

    /**
     * Title name.
     */
    private String title;

    /**
     * Getter for title.
     * @return value for title
     */
    public String getTitle(){
	return title;
    }

    /**
     * Setter for title.
     * @param s desired title
     */
    public void setTitle(String s){
	title = s;
    }
    
    /**
     * ISBN value.
     */
    private String isbn;

    /**
     * Getter for ISBN.
     * @return value for ISBN
     */
    public String getISBN(){
	return isbn;
    }

    /**
     * Setter for ISBN.
     * @param s desired ISBN
     */
    public void setISBN(String s){
	isbn = s;
    }

    /**
     * Default constructor.
     */
    public Book(){
    }

    /**
     * Constructor to set author, title, ISBN.
     * @param a name of the author
     * @param t name of the book
     * @param n value of the ISBN
     */
    public Book(String a, String t, String n){
	setAuthor(a);
	setTitle(t);
	setISBN(n);
    }

    /**
     * title, author, ISBN
     * @return title, author, ISBN
     */
    public String toString(){
	return getTitle() + ", " + getAuthor() + ", " + getISBN();
    }

    public static void main(String[]args){
	Book a = new Book("Animal Farm", "George Orwell", "Dewy");
	System.out.println(a);
    }
}
