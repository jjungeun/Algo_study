package stack;

import java.util.Scanner;

import stack.IntStack.OverflowIntStackException;

public class IntStackTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while(true) {
			System.out.println("���� ������ �� : "+s.size() + "/" + s.capacity());
			System.out.print("(1)Ǫ�� (2)�� (3)��ũ (4)���� (5)ã�� (6)����� (7)���� (0)���� : ");
			int menu = sc.nextInt();
			if(menu == 0) 
				break;
			
			int x;
			switch(menu) {
			case 1:
				System.out.print("������ : ");
				try{
					s.push(sc.nextInt());
				} catch(IntStack.OverflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
				
			case 2:
				try {
					System.out.println("���� �����ʹ� "+s.pop()+" �Դϴ�.");
				} catch(IntStack.EmptyIntStackException e) {
					System.out.println("������ ����ֽ��ϴ�.");
				}
				break;
				
			case 3:
				try {
					System.out.println("��ũ�� �����ʹ� "+s.peek()+" �Դϴ�.");
				} catch(IntStack.EmptyIntStackException e) {
					System.out.println("������ ����ֽ��ϴ�.");
				}
				break;
				
			case 4:
				s.dump();
				break;
			
			case 5:
				System.out.print("ã�� ������ : ");
				try {
					int index = s.indexOf(sc.nextInt());
					if(index != -1) {
						System.out.println("�� �����ʹ� �������� "+(s.size()-index)+"�� �ֽ��ϴ�.");
					} else {
						System.out.println("�� �����ʹ� �����ϴ�.");
					}
				} catch(IntStack.EmptyIntStackException e) {
					System.out.println("������ ����ֽ��ϴ�.");
				}
				break;
				
			case 6:
				s.clear();
				break;
				
			case 7:
				System.out.println("�뷮 : "+s.size());
				System.out.println("������ : "+s.capacity());
				System.out.println("���"+(s.isEmpty() ? "�ֽ��ϴ�":"���� �ʽ��ϴ�."));
				System.out.println("����"+(s.isFull() ? "á���ϴ�":"������ �ʽ��ϴ�."));
			}
		}
	}

}
