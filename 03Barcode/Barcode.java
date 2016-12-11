public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private String[]values = {"||:::", //0
			      ":::||", //1
			      "::|:|", //2
			      "::||:", //3
			      ":|::|", //4
			      ":|:|:", //5
			      ":||::", //6
			      "|:::|", //7
			      "|::|:", //8
			      "|:|::", //9
    };

    public String getZip(){
	return _zip;
    }

    public int compareTo(Barcode other){
	return (this.getZip()).compareTo(other.getZip());
	
    }


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
	Barcode b = new Barcode("18249");
	System.out.println(b);
	System.out.println(a.compareTo(b));
	System.out.println(b.compareTo(a));
    }
    
}
