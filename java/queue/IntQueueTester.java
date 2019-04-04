package queue;

import java.util.Scanner;

public class IntQueueTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntQueue q = new IntQueue(64);
		
		while(true) {
			System.out.println("현재 데이터 수 : "+q.size()+"/"+q.capacity());
			System.out.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (0)종료 :");
			int menu = sc.nextInt();
			if(menu == 0) {
				break;
			}
			
			switch(menu) {
			case 1:
				System.out.print("데이터 : ");
				try{
					q.enque(sc.nextInt());
				} catch(IntQueue.OverflowIntQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;
				
			case 2:
				try {
					System.out.println("디큐한 데이터는 "+q.deque()+"입니다.");
				} catch(IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어있습니다.");
				}
				break;
				
			case 3:
				try {
					System.out.println("피크한 데이터는 "+q.peek()+"입니다.");
				} catch(IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어있습니다.");
				}
				break;
				
			case 4:
				q.dump();
				break;
			}
		}
	}

}
