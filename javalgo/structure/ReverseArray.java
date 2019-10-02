package javalgo.structure;

import java.util.Scanner;

public class ReverseArray {

	static void swap(int[] a,int p1,int p2) {
		int tmp = a[p1];
		a[p1] = a[p2];
		a[p2] = tmp;
	}
	
	static void reverse(int[] arr) {
		for(int i=0;i<arr.length/2;i++) {
			System.out.println("x["+i+"]��  x["+(arr.length-i-1)+"]�� ��ȯ�մϴ�.");
			swap(arr,i,arr.length-i-1);
			for(int k=0;k<arr.length;k++) {
				System.out.print(arr[k]+" ");
			}
			System.out.println();
		}
	}
	
	static int sumOf(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��ڼ�:");
		int n = sc.nextInt();
		
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("x["+i+"] : ");
			arr[i]=sc.nextInt();
		}
		
		for(int k=0;k<n;k++) {
			System.out.print(arr[k]+" ");
		}
		System.out.println();
		
		reverse(arr);
		
		System.out.println("�迭�� ��� ����� ���� "+sumOf(arr)+"�Դϴ�.");
	}
}
