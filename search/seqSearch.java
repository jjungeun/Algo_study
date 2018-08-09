package search;

import java.util.Scanner;

public class seqSearch {
	
	static int seqSearch(int[] x,int num) {
	
		System.out.print(" | ");
		for(int i=0;i<x.length;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("-+----------------------");
		for(int i=0;i<x.length;i++) {
			System.out.print(" |");
			System.out.printf(String.format("%%%ds*\n", (i*2)+1), "");
			System.out.print(i+"|");
			for(int j=0;j<x.length;j++)
				System.out.print(" "+x[j]);
			System.out.println();
			if(x[i]==num) {
				return i;
			}
		}
		return -1;
	}
	
	
	static int searchIdx(int[] x,int num,int search,int[] idx) {
		int total = 0;
		for(int i=0;i<num;i++) {
			if(x[i] == search) {
				idx[total] = i;
				total++;
			}
		}
		for(int j=0;j<total;j++)
			System.out.println(idx[j]);
		
		return total;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��ڼ�:");
		int num = sc.nextInt();
		int[] x = new int[num];
		
		for(int i=0;i<num;i++) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("�˻��� �� : ");
		int search = sc.nextInt();
		int index = seqSearch(x,search);
		if(index != 0)
			System.out.println(search+"�� x["+index+"]�� �ֽ��ϴ�.");
		else
			System.out.println("��Ұ� �����ϴ�.");
	}

}
