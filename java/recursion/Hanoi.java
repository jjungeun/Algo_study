package recursion;

import java.util.Scanner;

public class Hanoi {
	
	/* no : ���� ����
	 * x : ���� ��� ��ȣ
	 * y : ��ǥ ��� ��ȣ  */
	static void move(int no, int x,int y) {
		if(no>1)
			move(no-1,x,6-x-y);
		
		System.out.println("����["+no+"]��"+x+"��տ��� "+y+"������� �ű�");
		
		if(no>1)
			move(no-1,6-x-y,y);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� : ");
		int no = sc.nextInt();
		move(no,1,3);
	}

}
