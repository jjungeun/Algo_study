package recursion;

import java.util.Scanner;

public class EuclidGCD {
	
	static int gcd(int x,int y) {
		
		//��͸޼��� ȣ���� ���
		if(y==0) {
			return x;
		}else {
			System.out.println(x%y);
			return gcd(y,x%y);
		}
		
		//��� �޼��� ȣ������ ���� ���
/*		int n=y;
		int tmp;
		for(int i=x;;) {
			if(n==0) {
				return i;
			}
			else {
				i=i%n;
				
				tmp = i;
				i = n;
				n= tmp;
			}
		}*/
		
		//��� �޼��� ȣ������ ���� ��� - ȿ��������!
/*		while(y!=0) {
			int temp = y;
			y = x%y;
			x = temp;
		}
		return x;*/
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ������ �ִ������� ���Ѵ�.");
		System.out.print("������ �Է��ϼ��� : ");
		int x = sc.nextInt();
		System.out.print("������ �Է��ϼ��� : ");
		int y = sc.nextInt();
		System.out.println("�ִ� ������� "+gcd(x, y));
	}

}
