package javalgo.recursion;

import java.util.Scanner;

public class Factorial {
	
	static int factorial(int n) {
		if(n>1) {
			return n*factorial(n-1);
		}else {
			return 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� :");
		int n = sc.nextInt();
		System.out.println(n+"! = "+factorial(n));
	}

}
