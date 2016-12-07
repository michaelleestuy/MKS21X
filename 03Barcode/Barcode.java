public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private int _checkDigit;
    


    private static final String one = ":::||";
    private static final String two = "::|:|";
    private static final String three = "::||:";
    private static final String four = ":|::|";
    private static final String five = ":|:|:";
    private static final String six = ":||::";
    private static final String seven = "|:::|";
    private static final String eight = "|::|:";
    private static final String nine = "|:|::";
    private static final String zero = "||:::";


    public Barcode(String zip){
	if(zip.length() != 5){
	    RuntimeException e = new RuntimeException("Incorrect barcode length");
	    throw e;
	}
	_zip = zip;
	_checkDigit = this.checkSum();
    }
    
    public int compareTo(Barcode other){
	return 7;
    }

    private int checkSum(){
	int sum = 0;
        for(int i = 0; i < 5; i++){
	    sum += (int)(_zip.charAt(i));
	}
	return sum % 10;
    }

}
