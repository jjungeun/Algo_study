package structure;

import java.util.Random;
import java.util.Scanner;

public class MaxofArrayRand {
	
	static int maxOf(int[] arr) {
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max)
				max=arr[i];
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand= new Random();
		System.out.println("Ű�� �ִ��� ���մϴ�.");
		System.out.print("��� ��:");
		int num = sc.nextInt();
		int[] harr = new int[num];
		System.out.println();
		for(int i=0;i<num;i++) {
			harr[i] = rand.nextInt(90)+100;
			System.out.println("height["+i+"] :"+harr[i]);
		}
		System.out.println("�ִ��� "+maxOf(harr)+"�Դϴ�.");
	}

}
