package javalgo.stack;

import javalgo.stack.IntStack.EmptyIntStackException;
// import javalgo.stack.IntStack.OverflowIntStackException;

/* 
 * 하나의 배열을 공유하여 2개의 스택을 구현하는 int형 데이터용 스택 클래스
 * 스택에 저장하는 데이터는 int형이고 배열의 처음과 끝을 사용한다.
 */

public class IntStackX {
	private int max;	//스택 A,B의 합
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
	
		// 스택에 데이터를 push
		public int push(int stack,int x) throws OverflowIntStackX2Exception{
			if(ptrA <= ptrB+1)
				throw new OverflowIntStackX2Exception();
			if(stack == 1) {	//스택 A일 경우
				stk[ptrA++] = x;
			} else {			//스택 B일 경우
				stk[ptrB--] = x;
			}
			return x;
		}
		
		// 스택에서 데이터를 pop
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
		
		// 스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
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
		
		// 스택에서 x를 찾아 인덱스를 반환
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
		
		// 스택을 비움
		public void clear(int stack){
			if(stack==1) {
				ptrA = 0;
			} else {
				ptrB = max-1;
			}
		}
		
		//스택의 용량을 반환
		public int capacity() {
			return max;
		}
		
		//스택에 쌓여있는 데이터 수 반환
		public int size(int stack) {
			if(stack == 1) {
				return ptrA;
			} else {
				return max-1-ptrB;
			}
		}
		
		//스택이 비어있는가?
		public boolean isEmpty(int stack) {
			if(stack==1) {
				return ptrA <= 0;
			} else {
				return ptrB >= max-1;
			}
		}
		
		// 스택이 가득 찼는가?
		public boolean isFull() {
			return ptrA >= ptrB+1;
		}

		// 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
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
