public class Barcode{
    private String _zip;


    public Barcode(String zip){
	if (zip.length() != 5){
	    throw new IllegalArgumentException("Incorrect zip length"); 
	}

	for(int i = 0; i < 5; i++){
	    if (!(zip.charAt(i) >= '0' && zip.charAt(i) <= '9')){
		    throw new IllegalArgumentException("Incorrect Non digit inside zip");
		}
	}
	_zip = zip;

	int a = 0;
	for(int i = 0; i < 5; i++){
	    a += zip.charAt(i);
	}
	_zip += (a % 10);
	
    }

    public String toString(){
	return _zip;
    }

    public static void main(String[]args){
	Barcode a = new Barcode("41824");
	System.out.println(a);
    }
    
}
