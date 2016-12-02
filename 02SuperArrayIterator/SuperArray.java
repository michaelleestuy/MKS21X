public class SuperArray implements Iterable<String>{
	private String[]data;
	private int size;

	public Iterator<String> iterator(){
	    return new SuperArrayIterator(this);
	}
	
	
	public SuperArray(){
		data = new String[10];
		size = 0;
	}
	
	public SuperArray(int input){
		if( input < 0){
			throw new IllegalArgumentException("unacceptable size of " + input);
		}
		data = new String[input];
		size = 0;
	}
	
	//good
	public int size(){
		return size;
	}
	
	//good
	public boolean add(String n){
		if(size % 10 == 0 && size != 0){
				this.grow();
				data[size] = n;
				size++;
		}
		else{
		data[size] = n;
		size++;
		}
		return true;
	}
	
	//good
	public String get(int a){
		if( a < 0 || a >= size){
			throw new IndexOutOfBoundsException("index of " + a);
		}
		return data[a];
	}
	
	//good
	public void clear(){
		size = 0;	
	}
	
	//good
	public boolean isEmpty(){
		return (size == 0);
	}
	
	//good
	public String set(int index, String element){
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException("index of " + index);
		}
		String a = data[index];
		data[index] = element;
		return a;
	}
	
	//good
	private void grow(){
		String[] temp = new String[data.length * 2 + 1];
		for (int i = 0; i < size; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	
	//good
	public String toString(){
		String a = "[ ";
		if (size != 0){
			a += data[0];
		}
		for ( int i = 1; i < size; i++){
			a += ", " + data[i];
		}
		a += "]";
		return a;
	}
	
	//good
	public String toStringDebug(){
		String a = "[ ";
		if (size != 0){
		    a+= data[0];
		}
		for ( int i = 1; i < data.length; i++){
			if(i >= size){
				a += ", _ ";
			}
			else{
				a += ", " + data[i];
			}
		}
		return a += "]";
	}

	//good
	public void add(int index, String element){
		if( index < 0 || index > size){
			throw new IndexOutOfBoundsException("index of "+ index);
		}
		SuperArray temp = new SuperArray();
		for( int i = 0; i < size; i++){
			temp.add(this.get(i));
		}
		
		size = index;
		this.add(element);
		
		for( int i = index; i < temp.size(); i ++){
			this.add(temp.get(i));
		}
	}
	
	//good
	public String remove(int index){
		if( index < 0 || index >= size){
			throw new IndexOutOfBoundsException("index of " + index);
		}
		SuperArray temp = new SuperArray();
		for( int i = 0; i < size; i++){
			temp.add(this.get(i));
		}
		
		size = index;
		
		for(int i = index + 1; i < temp.size(); i++){
			this.add(temp.get(i));
		}
		
		return temp.get(index);
	}
	
	//good
	public String[] toArray(){
		String[]a = new String[size];
		for( int i = 0; i < size; i++){
			a[i] = this.get(i);
		}
		return a;
	}
	
	//good
	public int indexOf(String a){
		for( int i = 0; i < size; i++){
		    if( this.get(i).equals(a)){
				return i;
			}
		}
		return -1;
	}
	
	//good
	public int lastIndexOf(int a){
		for( int i = size - 1; i >= 0; i--){
		    if( this.get(i).equals(a)){
				return i;
			}
		}
		return -1;
	}
	
	//good
	public void trimToSize(){
		String[]temp = new String[size];
		for(int i = 0; i < size; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	
	public static void main(String[]args){
		SuperArray a = new SuperArray();
		a.add("0");
		a.add("1");
		a.add("2");
		a.set(2,"20");
		System.out.println(a);
		System.out.println(a.indexOf("1"));
	}
}

