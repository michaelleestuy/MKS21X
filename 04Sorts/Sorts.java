public class Sorts{
    
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "10.Lee.Michael";
    }
    
    public static void swap(int[]ary, int a, int b){
	int c = ary[b];
	ary[b] = ary[a];
	ary[a] = c;
    }
    
    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[]data){
	for(int college = 0; college < data.length - 1; college++){
	    int small = data[college];
	    int ofSmall = college;
	    for(int board = college; board < data.length; board++){
		if(data[board] < small){
		    small = data[board];
		    ofSmall = board;
		}
	    }
	    swap(data, college, ofSmall);
	}
    }

    public static void print(int[]a){
	for(int i = 0; i < a.length; i++){
	    System.out.print(a[i] + " ");
	}
    }
    
    public static void main(String[]args){
	int[]a = {11, 41, 124, 42, 44, 44, 11, -10};
	print(a);
	selectionSort(a);
	System.out.println();
	print(a);


    }


}
