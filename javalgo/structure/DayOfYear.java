package javalgo.structure;

import java.util.Scanner;

public class DayOfYear {
	
	static int[][] mdays= {
			{31,28,31,30,31,30,31,31,30,31,30,31},		//평년
			{31,29,31,30,31,30,31,31,30,31,30,31}		//윤년
	};
	
	static int isLeap(int year) {
		if(year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {		//평년일 경우
			return 0;
		}
		return 1;
	}
	
	//그 해의 경과 일수를 구함
	static void dayOfYear(int leap, int m, int d) {
		/*int days = d;
		for(int i=0;i<m-1;i++) {
			days += mdays[y][i];
		}
		System.out.println("그 해 "+days+"일 째 입니다.");*/
		
		/* 위의 결과와 똑같음.
		 * 변수 i와 days없이 구현 */
		while(--m > 0) {
			d += mdays[leap][m-1];
		}
		System.out.println("그 해 "+ d+"일 째 입니다.");
	}
	
	//연내의 남은 일수 구함
	static void leftDayOfYear(int leap, int m, int d) {
		/*int ldays = mdays[y][m-1] - d;
		for(int i=m;i<11;i++) {
			ldays += mdays[y][i];
		}
		System.out.println(ldays+"일 남았습니다.");*/
		
		//개선 알고리즘
		while(--m > 0) {
			d += mdays[leap][m-1];
		}
		System.out.println((365+leap-d)+"일 남았습니다.");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int again = 1;
		while(again == 1) {
			System.out.print("년 : ");
			int year = sc.nextInt();
			System.out.print("월 : ");
			int month = sc.nextInt();
			System.out.print("일 : ");
			int day = sc.nextInt();
			
			dayOfYear(isLeap(year), month, day);
			leftDayOfYear(isLeap(year), month, day);
			System.out.print("한번 더 할 까요?(y:1/n:0) :");
			again=sc.nextInt();
		}
	}
	
}
