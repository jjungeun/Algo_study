package javalgo.search;

import java.util.Scanner;

/*
 * 종료조건을 검사하는 비용을 줄이자!
 * 이 비용을 반으로 줄이는 방법 -> 보초법
 * 종료조건1 : 배열의 끝까지 간 경우
 * 종료조건2 : 검색할 값을 발견한 경우
 * 
 * 보초법에서는 원래 배열의 끝에 검색하려는 값을 추가함으로써 
 * 종료조건1을 없앤다.
 */

public class seqSearchSen {
	
	static int seqSearchSen(int[] x,int length, int num) {
		
		//while문 사용
		/*
		int i=0;
		while(true) {
			if(x[i] == num) {
				break;
			}
			i++;
		}
			return i == length ? -1 : i;
		*/
	
		System.out.print("   | ");
		
		//for문 사용
		for(int i=0;;i++) {
			System.out.println(i+" ");
			if(x[i] == num) {
				return i == length ? -1 : i;
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("요솟수:");
		int num = sc.nextInt();
		int[] x = new int[num+1];
		
		for(int i=0;i<num;i++) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		
		
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();
		x[num] = search;
		int index = seqSearchSen(x,num,search);
		if(index != -1)
			System.out.println(search+"은 x["+index+"]에 있습니다.");
		else
			System.out.println("요소가 없습니다.");
	}

}
