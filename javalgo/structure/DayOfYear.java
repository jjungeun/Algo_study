package javalgo.structure;

import java.util.Scanner;

public class DayOfYear {
	
	static int[][] mdays= {
			{31,28,31,30,31,30,31,31,30,31,30,31},		//���
			{31,29,31,30,31,30,31,31,30,31,30,31}		//����
	};
	
	static int isLeap(int year) {
		if(year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {		//����� ���
			return 0;
		}
		return 1;
	}
	
	//�� ���� ��� �ϼ��� ����
	static void dayOfYear(int leap, int m, int d) {
		/*int days = d;
		for(int i=0;i<m-1;i++) {
			days += mdays[y][i];
		}
		System.out.println("�� �� "+days+"�� ° �Դϴ�.");*/
		
		/* ���� ����� �Ȱ���.
		 * ���� i�� days���� ���� */
		while(--m > 0) {
			d += mdays[leap][m-1];
		}
		System.out.println("�� �� "+ d+"�� ° �Դϴ�.");
	}
	
	//������ ���� �ϼ� ����
	static void leftDayOfYear(int leap, int m, int d) {
		/*int ldays = mdays[y][m-1] - d;
		for(int i=m;i<11;i++) {
			ldays += mdays[y][i];
		}
		System.out.println(ldays+"�� ���ҽ��ϴ�.");*/
		
		//���� �˰���
		while(--m > 0) {
			d += mdays[leap][m-1];
		}
		System.out.println((365+leap-d)+"�� ���ҽ��ϴ�.");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int again = 1;
		while(again == 1) {
			System.out.print("�� : ");
			int year = sc.nextInt();
			System.out.print("�� : ");
			int month = sc.nextInt();
			System.out.print("�� : ");
			int day = sc.nextInt();
			
			dayOfYear(isLeap(year), month, day);
			leftDayOfYear(isLeap(year), month, day);
			System.out.print("�ѹ� �� �� ���?(y:1/n:0) :");
			again=sc.nextInt();
		}
	}
	
}
