package queue;

import java.util.Scanner;

public class IntQueueTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntQueue q = new IntQueue(64);
		
		while(true) {
			System.out.println("���� ������ �� : "+q.size()+"/"+q.capacity());
			System.out.print("(1)��ť (2)��ť (3)��ũ (4)���� (0)���� :");
			int menu = sc.nextInt();
			if(menu == 0) {
				break;
			}
			
			switch(menu) {
			case 1:
				System.out.print("������ : ");
				try{
					q.enque(sc.nextInt());
				} catch(IntQueue.OverflowIntQueueException e) {
					System.out.println("ť�� ���� á���ϴ�.");
				}
				break;
				
			case 2:
				try {
					System.out.println("��ť�� �����ʹ� "+q.deque()+"�Դϴ�.");
				} catch(IntQueue.EmptyIntQueueException e) {
					System.out.println("ť�� ����ֽ��ϴ�.");
				}
				break;
				
			case 3:
				try {
					System.out.println("��ũ�� �����ʹ� "+q.peek()+"�Դϴ�.");
				} catch(IntQueue.EmptyIntQueueException e) {
					System.out.println("ť�� ����ֽ��ϴ�.");
				}
				break;
				
			case 4:
				q.dump();
				break;
			}
		}
	}

}
