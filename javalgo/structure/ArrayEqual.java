package javalgo.structure;

import java.util.Scanner;

public class ArrayEqual {

	static boolean equals(int[] a, int[] b) {
		if(a.length != b.length) {
			return false;
		}
		for(int i=0;i<a.length;i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
	
	static void copy(int[] a,int[] b) {
		for(int i=0;i<a.length;i++) {
			b[i] = a[i];
		}
	}
	
	static void rcopy(int[] b,int[] a) {
		for(int i=0;i<b.length;i++) {
			a[b.length-1-i]=b[i];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭 a�� ��ڼ� : ");
		int na = sc.nextInt();
		int[] a = new int[na];
		for(int i=0;i<na;i++) {
			System.out.print("a["+i+"]:");
			a[i]=sc.nextInt();
		}
		
		int[] b = new int [na];
		copy(a,b);
		for(int i=0;i<na;i++) {
			System.out.println("b["+i+"] : "+b[i]);
		}
		
		rcopy(b,a);
		for(int i=0;i<na;i++) {
			System.out.println("a["+i+"] : "+a[i]);
		}
		
		
		/*System.out.print("�迭 b�� ��ڼ� : ");
		int nb = sc.nextInt();
		int[] b = new int[nb];
		for(int i=0;i<nb;i++) {
			System.out.print("b["+i+"]:");
			b[i] = sc.nextInt();
		}
		
		if(equals(a,b)) {
			System.out.println("�� �迭�� �����ϴ�.");
		}
		else {
			System.out.println("�� �迭�� �ٸ��ϴ�.");
		}*/
	}
}
