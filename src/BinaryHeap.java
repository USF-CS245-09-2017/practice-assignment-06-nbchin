
import java.util.NoSuchElementException;

public class BinaryHeap {
	
	int[] arr = new int[10];
	int size = 0;
	
	public void add(int priority) {
		// TODO Auto-generated method stub
		if(size == arr.length - 1){
			growHeap();
		} 		
		arr[size++] = priority;
		int index = size - 1;
		while( index > 0 && arr[index] < arr[parent(index)]){
			swap(index, parent(index));
			index = parent(index);
		}
	}

	private void swap(int index, int parent) {
		// TODO Auto-generated method stub
		int temp = arr[index];
		arr[index] = arr[parent];
		arr[parent] = temp;
	}

	public void growHeap() {
		// TODO Auto-generated method stub
		int[] newArr = new int[arr.length * 2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
	

	public int remove() {
		// TODO Auto-generated method stub
		if(arr.length <= 0){  
			throw new NoSuchElementException();
		}
		int removed = arr[0];
		arr[0] = arr[--size];
		int index = 0;
		int child = leftChild(index);
		if(child < 0 || child > size - 1)
			return removed;
		if(rightChild(index) < size - 1 && arr[rightChild(index)] < arr[child]){ 
			child = rightChild(index);
		}
		
		while( child < size && arr[child] < arr[index]){			
			swap(index, child);			
 			index = child;
			child = leftChild(index);
			if(rightChild(index) < size && arr[rightChild(index)] < arr[child]){ //child?
				child = rightChild(index);
			}
			
		}
		
		return removed;
	}

	protected int parent(int i){
		return (i - 1) / 2; // i/2?
	}
	
	protected int leftChild(int i){
		return (i * 2) + 1; //2i?
	}
	
	protected int rightChild(int i){
		return (i * 2) + 2; //2i + 1?
	}
	
	public void printHeap(){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	
}

