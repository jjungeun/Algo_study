package javalgo.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��ڼ�:");
		int num = sc.nextInt();
		int[] x = new int[num];
		System.out.println("������������ �Է��ϼ���.");
		System.out.print("x[0] : ");
		x[0]=sc.nextInt();
		
		for(int i=1;i<num;i++) {
			do{
				System.out.print("x["+i+"] : ");
				x[i] = sc.nextInt();
			}while(x[i-1] > x[i]);
		}
		
		
		System.out.print("�˻��� �� : ");
		int search = sc.nextInt();
		int index = Arrays.binarySearch(x, search);
		if(index > 0) {
			System.out.println(search+"�� x["+index+"]�� �ֽ��ϴ�.");
		}
		else {
			System.out.println("�� ���� ��Ұ� �����ϴ�. ���� ����Ʈ��"+(0-(index+1))+"�Դϴ�.");
		}
	}

}
