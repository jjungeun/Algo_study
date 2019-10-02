package javalgo.queue;

public class IntQueue {
	private int max;
	private int num;
	private int[] que;
	private int front;
	private int rear;
	
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException () {}
	}
	
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException() {}
	}
	
	
	public IntQueue(int capacity) {
		max = capacity;
		num = front = rear = 0;
		try{
			que = new int[max];
		} catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	// 큐에서 데이터를 인큐
	public int enque(int x) throws OverflowIntQueueException{
		if(num >= max) {
			throw new OverflowIntQueueException();
		}
		que[rear++] = x;
		num++;
		if(rear == max) {
			rear = 0;
		}
		return x;
	}
	
	// 큐에서 데이터를 디큐
	public int deque() throws EmptyIntQueueException{
		if(num <= 0) {
			throw new EmptyIntQueueException();
		}
		int x = que[front++];
		num--;
		if(front == max) {
			front = 0;
		}
		return x;
	}
	
	// 큐에서 데이터를 피크(프런트 데이터를 들여다봄)
	public int peek() throws EmptyIntQueueException{
		if(num <= 0) {
			throw new EmptyIntQueueException();
		}
		return que[front];
	}
	
	// 큐에서 x를 검색하여 인덱스를 반환(찾지 못하면 -1)
	public int indexOf(int x){
		for(int i=0;i<num;i++) {
			int index = (front+i) % max;
			if(que[index] == x)
				return index;
		}
		return -1;
	}
	
	// 큐를 비움
	public void clear() {
		num = front = rear = 0;
	}
	
	// 큐의 용량을 반환
	public int capacity() {
		return max;
	}
	
	// 큐에 쌓여있는 데이터수 반환
	public int size() {
		return num;
	}
	
	// 큐가 비어 있나요?
	public boolean isEmpty() {
		return num <= 0;
	}
	
	// 큐가 가득 찼나요?
	public boolean isFull() {
		return num >= max;
	}
	
	// 큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
	public void dump() {
		if(num<=0) {
			System.out.println("큐가 비었습니다.");
		}
		else {
			for(int i=0;i<num;i++) {
				int index = (front+i) % max;
				System.out.println(que[index]);
			}
		}
	}
	
	// 큐 안에 몇번째에 있는지 search
	public int search(int x) {
		for(int i=0;i<num;i++) {
			int index = (front+i) % max;
			if(que[index] == x) {
				return i+1;
			}
		}
		return 0;
	}
}
