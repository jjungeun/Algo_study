package javalgo.queue;

import java.util.Scanner;

/* 
 * 링 버퍼의 활용 : 오래된 데이터를 버리는 용도
 * 정수 입력(인큐)은 무한히 할 수 있지만 배열에 저장되는 데이터는 
 * 가장 최근에 입력한 10개의 데이터만 링버퍼에 남아있다.
 */
public class LastNElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max= 10;
		int[] buf = new int[max];
		int num=0;
		int retry = 1;
		
		System.out.println("정수를 입력하세요 ");
		
		while(retry == 1) {
			System.out.printf("%d 번째 정수 :",num+1);
			buf[num++ % max] = sc.nextInt();
			System.out.print("계속 할까요?(예.1/아니오.0)");
			retry = sc.nextInt();
		}
		
		int i= num-max;
		if(i<0) i=0;
		
		for(;i<num;i++) {
			System.out.printf("%d번째의 정수 = %d\n",i+1,buf[i%max]);
		}
		
	}

}
