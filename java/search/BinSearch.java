package search;

import java.util.Scanner;

public class BinSearch {
	
	static int binSearch(int[] x,int num,int search) {
		int pl=0;
		int pr = num-1;
		
		do {
			int pc = (pl+pr)/2;
			if(x[pc] == search) {
				return pc;
			}
			else if(x[pc] < search) {
				pl = pc + 1;
			}
			else {
				pr = pc - 1;
			}
		} while(pl <= pr);
		
		return -1;
	}
	
	
	//같은 값을 갖는 요소가 있을 경우
	static int binSearchX(int[] x,int num,int search) {
		int pl=0;
		int pr = num-1;
		
		do {
			int pc = (pl+pr)/2;
			if(x[pc] == search) {
				while(pc>pl) {
					if(x[pc] != x[pc-1])
						break;
					pc--;
				}
				return pc;
			}
			else if(x[pc] < search) {
				pl = pc + 1;
			}
			else {
				pr = pc - 1;
			}
		} while(pl <= pr);
		
		return -1;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("요솟수:");
		int num = sc.nextInt();
		int[] x = new int[num];
		System.out.println("오름차순으로 입력하세요.");
		System.out.print("x[0] : ");
		x[0]=sc.nextInt();
		
		for(int i=1;i<num;i++) {
			do{
				System.out.print("x["+i+"] : ");
				x[i] = sc.nextInt();
			}while(x[i-1] > x[i]);
		}
		
		
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();
//		int index = binSearch(x, num, search);
		int index = binSearchX(x, num, search);
		if(index != -1) {
			System.out.println(search+"는 x["+index+"]에 있습니다.");
		}
		else {
			System.out.println("그 값의 요소가 없습니다.");
		}
	}
}
