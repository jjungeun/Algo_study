package javalgo.search;

import java.util.Scanner;

/*
 * ���������� �˻��ϴ� ����� ������!
 * �� ����� ������ ���̴� ��� -> ���ʹ�
 * ��������1 : �迭�� ������ �� ���
 * ��������2 : �˻��� ���� �߰��� ���
 * 
 * ���ʹ������� ���� �迭�� ���� �˻��Ϸ��� ���� �߰������ν� 
 * ��������1�� ���ش�.
 */

public class seqSearchSen {
	
	static int seqSearchSen(int[] x,int length, int num) {
		
		//while�� ���
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
		
		//for�� ���
		for(int i=0;;i++) {
			System.out.println(i+" ");
			if(x[i] == num) {
				return i == length ? -1 : i;
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��ڼ�:");
		int num = sc.nextInt();
		int[] x = new int[num+1];
		
		for(int i=0;i<num;i++) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		
		
		System.out.print("�˻��� �� : ");
		int search = sc.nextInt();
		x[num] = search;
		int index = seqSearchSen(x,num,search);
		if(index != -1)
			System.out.println(search+"�� x["+index+"]�� �ֽ��ϴ�.");
		else
			System.out.println("��Ұ� �����ϴ�.");
	}

}
