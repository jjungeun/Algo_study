package stack;

import java.util.Scanner;

import stack.IntStack.OverflowIntStackException;

public class IntStackTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while(true) {
			System.out.println("현재 데이터 수 : "+s.size() + "/" + s.capacity());
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)찾기 (6)지우기 (7)정보 (0)종료 : ");
			int menu = sc.nextInt();
			if(menu == 0) 
				break;
			
			int x;
			switch(menu) {
			case 1:
				System.out.print("데이터 : ");
				try{
					s.push(sc.nextInt());
				} catch(IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
				
			case 2:
				try {
					System.out.println("팝한 데이터는 "+s.pop()+" 입니다.");
				} catch(IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
				
			case 3:
				try {
					System.out.println("피크한 데이터는 "+s.peek()+" 입니다.");
				} catch(IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
				
			case 4:
				s.dump();
				break;
			
			case 5:
				System.out.print("찾을 데이터 : ");
				try {
					int index = s.indexOf(sc.nextInt());
					if(index != -1) {
						System.out.println("이 데이터는 꼭대기부터 "+(s.size()-index)+"에 있습니다.");
					} else {
						System.out.println("그 데이터는 없습니다.");
					}
				} catch(IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
				
			case 6:
				s.clear();
				break;
				
			case 7:
				System.out.println("용량 : "+s.size());
				System.out.println("데이터 : "+s.capacity());
				System.out.println("비어"+(s.isEmpty() ? "있습니다":"있지 않습니다."));
				System.out.println("가득"+(s.isFull() ? "찼습니다":"차있지 않습니다."));
			}
		}
	}

}
