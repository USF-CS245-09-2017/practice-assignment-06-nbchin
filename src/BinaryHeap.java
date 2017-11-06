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

	private void growHeap() {
		// TODO Auto-generated method stub
		int[] newArr = new int[arr.length * 2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}

	public int remove() {
		// TODO Auto-generated method stub
		if(arr.length == 0){  
			throw new NoSuchElementException();
		}
		int removed = arr[0];
		arr[0] = arr[--size];
		int index = 0;
		int child = leftChild(index);
		if(arr[rightChild(index)] < arr[child] && child < size){
			child = rightChild(index);
		}
		
		while(arr[child] < arr[index] && child < size){		
			swap(index, child);
			index = child;
			child = leftChild(index);
			if(rightChild(index) < size && arr[rightChild(index)] < arr[index]){
				child = rightChild(index);
			}
			
			System.out.println("Arr child: " + arr[child]);
			System.out.println("arr[index]: " + arr[index]);
			System.out.println("Child: " + child + " - size: " + size);
			System.out.println();
			
			
			
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
