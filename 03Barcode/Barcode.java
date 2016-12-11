import java.util.*;

public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private static final String[]values = {"||:::", //0
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

    
    
    public static String toZip(String code){
	if(code.length() != 32){
	    throw new IllegalArgumentException("Incorrect length of code");
	}
	
	for(int i = 0; i < 32; i++){
	    if(!(code.charAt(i) == ':' || code.charAt(i) == '|')){
		throw new IllegalArgumentException("Invalid characters in code");
	    }
	}

	if(!(code.charAt(0) == '|' && code.charAt(31) == '|' )){
	    throw new IllegalArgumentException("Guard rails missing");
	}

	String nums = "";
	for(int i = 0; i < 6; i++){
	    String b = code.substring(i * 5 + 1, i * 5 + 6);
	    int c = Arrays.asList(values).indexOf(b);
	    if(c == -1){
		throw new IllegalArgumentException("Invalid encoded ints");
	    }
	    nums += c;
	}

	int sum = 0;
	for(int i = 0; i < 5; i++){
	    sum += Integer.parseInt("" + nums.charAt(i));
	}
	if(sum % 10 != Integer.parseInt("" + nums.charAt(5))){
	    throw new IllegalArgumentException("Check Digit is wrong");
	}

	return nums.substring(0, 5);
	
    }
    
    
    public static String toCode(String zip){
	if (zip.length() != 5){
	    throw new IllegalArgumentException("Incorrect zip length"); 
	}

	for(int i = 0; i < 5; i++){
	    if (!(zip.charAt(i) >= '0' && zip.charAt(i) <= '9')){
		    throw new IllegalArgumentException("Incorrect Non digit inside zip");
		}
	}

	String a = "";
	a += "|";
	for(int i = 0; i < 5; i++){
	    int b = Integer.parseInt("" + zip.charAt(i));
	    a += values[b];
	}


	int c = 0;
	for(int i = 0; i < 5; i++){
	    c += zip.charAt(i);
	}
	int b = c % 10;
	a += values[b];
	
	
	a += "|";
	return a;
    }

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

    /*
	int a = 0;
	for(int i = 0; i < 5; i++){
	    a += zip.charAt(i);
	}
	_zip += (a % 10);
    */

    public String toString(){
	return _zip + " " + toCode(_zip.substring(0, 5));
    }

    public static void main(String[]args){
	/*
	Barcode a = new Barcode("41824");
	System.out.println(a);
	Barcode b = new Barcode("18249");
	System.out.println(b);
	
	System.out.println(a.compareTo(b));
	System.out.println(b.compareTo(a));
	*/
	//System.out.println(toCode("47162"));
	//System.out.println(toCode("41828"));
	//System.out.println(toZip("||||||||||||||||||||||||||||||||"));
    }

    
}
