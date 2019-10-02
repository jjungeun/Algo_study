package javalgo.queue;

/*
 * 덱(deck)이라는 양방향 대기열. 
 * 시작과 끝 지점에서 양쪽으로 데이터를 인큐하거나 디큐하는 자료구조이다.
 * 다른것은 큐와 같으므로 인큐와 디큐만 구현했다.
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
