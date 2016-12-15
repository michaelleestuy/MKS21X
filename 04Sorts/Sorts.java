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

    public static void shift(int[]data, int a, int b){
	int c = data[b];
	for(int i = b; i > a; i--){
	    data[i] = data[i - 1];
	}
	data[a] = c;
    }

    /**Insertion sort of an int array.
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void insertionSort(int[]data){
	for(int college = 1; college < data.length; college++){
	    for(int board = college - 1; board >= 0; board--){
		if(data[college] > data[board]){
		    shift(data, board + 1, college);
		    board = -1;
		}
		if(board == 0 && data[college] <= data[board]){
		    shift(data, board, college);
		    board = -1;
		}
	    }
	    
	}
    }

    /**Bubble sort of an int array.
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void bubbleSort(int[]data){
	for(int college = 0; college < data.length; college++){
	    boolean clean = true;
	    for(int board = 0; board < data.length - college - 1; board++){
		if(data[board] > data[board + 1]){
		    swap(data, board, board + 1);
		    clean = false;
		}
	    }
	    if(clean){
		college = data.length;
	    }
	}
    }
    
    public static void print(int[]a){
	for(int i = 0; i < a.length; i++){
	    System.out.print(a[i] + " ");
	}
    }
    
    public static void main(String[]args){
	int[]a = { 0 ,1, 3,4,4,5,6,7,8,9,14,144};
	bubbleSort(a);
	print(a);
    }
}
