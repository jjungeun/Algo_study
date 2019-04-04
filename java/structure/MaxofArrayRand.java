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
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수:");
		int num = sc.nextInt();
		int[] harr = new int[num];
		System.out.println();
		for(int i=0;i<num;i++) {
			harr[i] = rand.nextInt(90)+100;
			System.out.println("height["+i+"] :"+harr[i]);
		}
		System.out.println("최댓값은 "+maxOf(harr)+"입니다.");
	}

}
