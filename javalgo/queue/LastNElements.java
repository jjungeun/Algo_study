package javalgo.queue;

import java.util.Scanner;

/* 
 * �� ������ Ȱ�� : ������ �����͸� ������ �뵵
 * ���� �Է�(��ť)�� ������ �� �� ������ �迭�� ����Ǵ� �����ʹ� 
 * ���� �ֱٿ� �Է��� 10���� �����͸� �����ۿ� �����ִ�.
 */
public class LastNElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max= 10;
		int[] buf = new int[max];
		int num=0;
		int retry = 1;
		
		System.out.println("������ �Է��ϼ��� ");
		
		while(retry == 1) {
			System.out.printf("%d ��° ���� :",num+1);
			buf[num++ % max] = sc.nextInt();
			System.out.print("��� �ұ��?(��.1/�ƴϿ�.0)");
			retry = sc.nextInt();
		}
		
		int i= num-max;
		if(i<0) i=0;
		
		for(;i<num;i++) {
			System.out.printf("%d��°�� ���� = %d\n",i+1,buf[i%max]);
		}
		
	}

}
