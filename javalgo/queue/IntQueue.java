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
	
	// ť���� �����͸� ��ť
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
	
	// ť���� �����͸� ��ť
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
	
	// ť���� �����͸� ��ũ(����Ʈ �����͸� �鿩�ٺ�)
	public int peek() throws EmptyIntQueueException{
		if(num <= 0) {
			throw new EmptyIntQueueException();
		}
		return que[front];
	}
	
	// ť���� x�� �˻��Ͽ� �ε����� ��ȯ(ã�� ���ϸ� -1)
	public int indexOf(int x){
		for(int i=0;i<num;i++) {
			int index = (front+i) % max;
			if(que[index] == x)
				return index;
		}
		return -1;
	}
	
	// ť�� ���
	public void clear() {
		num = front = rear = 0;
	}
	
	// ť�� �뷮�� ��ȯ
	public int capacity() {
		return max;
	}
	
	// ť�� �׿��ִ� �����ͼ� ��ȯ
	public int size() {
		return num;
	}
	
	// ť�� ��� �ֳ���?
	public boolean isEmpty() {
		return num <= 0;
	}
	
	// ť�� ���� á����?
	public boolean isFull() {
		return num >= max;
	}
	
	// ť ���� ��� �����͸� ����Ʈ -> ���� ������ ���
	public void dump() {
		if(num<=0) {
			System.out.println("ť�� ������ϴ�.");
		}
		else {
			for(int i=0;i<num;i++) {
				int index = (front+i) % max;
				System.out.println(que[index]);
			}
		}
	}
	
	// ť �ȿ� ���°�� �ִ��� search
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
