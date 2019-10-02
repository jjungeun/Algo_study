package javalgo.queue;

/*
 * ��(deck)�̶�� ����� ��⿭. 
 * ���۰� �� �������� �������� �����͸� ��ť�ϰų� ��ť�ϴ� �ڷᱸ���̴�.
 * �ٸ����� ť�� �����Ƿ� ��ť�� ��ť�� �����ߴ�.
 */
public class IntDeque {
	private int max;
	private int num;
	private int front;
	private int rear;
	private int[] que;
	
	public class EmptyIntDequeException extends RuntimeException{
		public EmptyIntDequeException() {}
	}
	
	public class OverflowIntDequeException extends RuntimeException{
		public OverflowIntDequeException() {}
	}
	
	public IntDeque(int capacity) {
		max = capacity;
		num = front = rear= 0;
		try {
			que = new int[max];
		} catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int enQueFront(int x) throws OverflowIntDequeException{
		if(num >= max) {
			throw new OverflowIntDequeException();
		}
		if(--front < 0) {
			front = max-1;
		}
		que[front] = x;
		num++;
		return x;
	}
	
	public int enQueRear(int x) throws OverflowIntDequeException{
		if(num >= max) {
			throw new OverflowIntDequeException();
		}
		que[rear++] = x;
		if(rear >= max) {
			rear=0;
		}
		num++;
		return x;
	}
	
	public int deQueFront() throws EmptyIntDequeException{
		if(num <= 0) {
			throw new EmptyIntDequeException();
		}
		int x = que[front++];
		if(front >= max) {
			front = 0;
		}
		num--;
		return x;
	}
	
	public int deQueRear() throws EmptyIntDequeException{
		if(num <= 0) {
			throw new EmptyIntDequeException();
		}
		if(--rear < 0) {
			rear = max-1;
		}
		int x = que[rear];
		num--;
		return x;
	}
}
