package javalgo.stack;

import javalgo.stack.IntStack.EmptyIntStackException;
// import javalgo.stack.IntStack.OverflowIntStackException;

/* 
 * �ϳ��� �迭�� �����Ͽ� 2���� ������ �����ϴ� int�� �����Ϳ� ���� Ŭ����
 * ���ÿ� �����ϴ� �����ʹ� int���̰� �迭�� ó���� ���� ����Ѵ�.
 */

public class IntStackX {
	private int max;	//���� A,B�� ��
	private int ptrA;
	private int ptrB;
	private int[] stk;
	
	public class EmptyIntStackX2Exception extends RuntimeException{
		public EmptyIntStackX2Exception() {}
	}
	
	public class OverflowIntStackX2Exception extends RuntimeException{
		public OverflowIntStackX2Exception() {}
	}
	
	public IntStackX(int capacity) {
		max = capacity;
		ptrA = 0;
		ptrB = max - 1;
		
		try {
			stk = new int[max];
		} catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
		// ���ÿ� �����͸� push
		public int push(int stack,int x) throws OverflowIntStackX2Exception{
			if(ptrA <= ptrB+1)
				throw new OverflowIntStackX2Exception();
			if(stack == 1) {	//���� A�� ���
				stk[ptrA++] = x;
			} else {			//���� B�� ���
				stk[ptrB--] = x;
			}
			return x;
		}
		
		// ���ÿ��� �����͸� pop
		public int pop(int stack) throws EmptyIntStackException{
			if(stack == 1) {
				if(ptrA <= 0)
					throw new EmptyIntStackX2Exception();
				return stk[--ptrA];
			} else {
				if(ptrB >= max-1)
					throw new EmptyIntStackX2Exception();
				return stk[++ptrB];
			}
		}
		
		// ���ÿ��� �����͸� ��ũ(���� �ִ� �����͸� �鿩�ٺ�)
		public int peek(int stack) throws EmptyIntStackException{
			if(stack == 1) {
				if(ptrA <= 0) {
					throw new EmptyIntStackX2Exception();
				}
				return stk[ptrA-1];
			} else {
				if(ptrB >= max-1)
					throw new EmptyIntStackX2Exception();
				return stk[ptrB+1];
			}
		}
		
		// ���ÿ��� x�� ã�� �ε����� ��ȯ
		public int indexOf(int stack, int x) {
			if(stack == 1) {
				for(int i=ptrA-1;i>=0;i--) {
					if(stk[i] == x) {
						return i;
					}
				}
			} else {
				for(int i=ptrB+1;i<=max;i++) {
					if(stk[i] == x) {
						return i;
					}
				}
			}
			return -1;
		}
		
		// ������ ���
		public void clear(int stack){
			if(stack==1) {
				ptrA = 0;
			} else {
				ptrB = max-1;
			}
		}
		
		//������ �뷮�� ��ȯ
		public int capacity() {
			return max;
		}
		
		//���ÿ� �׿��ִ� ������ �� ��ȯ
		public int size(int stack) {
			if(stack == 1) {
				return ptrA;
			} else {
				return max-1-ptrB;
			}
		}
		
		//������ ����ִ°�?
		public boolean isEmpty(int stack) {
			if(stack==1) {
				return ptrA <= 0;
			} else {
				return ptrB >= max-1;
			}
		}
		
		// ������ ���� á�°�?
		public boolean isFull() {
			return ptrA >= ptrB+1;
		}

		// ���� ���� ��� �����͸� �ٴ� -> ����� ������ ���
		public void dump(int stack) {
			if(stack == 1) {
				if(ptrA <= 0)
					throw new EmptyIntStackX2Exception();
				for(int i=0;i<ptrA;i++) {
					System.out.println(stk[i]);
				}
			} else {
				if(ptrB >= max-1)
					throw new EmptyIntStackX2Exception();
				for(int i=max-1;i>ptrB;i--) {
					System.out.println(stk[i]);
				}
			}
		}
}
