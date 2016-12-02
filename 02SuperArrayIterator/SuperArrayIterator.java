import java.util.Iterator;


public class SuperArrayIterator implements Iterator<String>{
    private SuperArray a;
    private int index;
    
    private void setIndex(int i){
	index = i;
    }

    public SuperArrayIterator(SuperArray b){
	a = b;
	setIndex(0);
    }
    
    public boolean hasNext(){
	return index < a.size();
    }
    
    public String next(){
	index ++;
	return a.get(index - 1);
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
    
}
