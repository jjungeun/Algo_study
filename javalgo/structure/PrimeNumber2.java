package javalgo.structure;

/* 소수 구하는 알고리즘 - 알고리즘 개선1
 * 2이상의 짝수는 소수가 아니고, 홀수들은 소수들의 배수가 아니라면 소수이다. */

public class PrimeNumber2 {

	public static void main(String[] args) {
		int counter = 0; //나눗셈 횟수
		int[] prime = new int[100];	//소수의 배열
		int pnum = 0; //소수의 개수
		
		prime[pnum++] = 2;	//2는 소수이다.
		
		for(int n=3;n<100;n+=2) {			//짝수는 제외하고 홀수만 생각한다.
			int i;
			for(i=1;i<pnum;i++) {			//2이상의 소수는 모두 홀수이므로 2로 나누는 경우는 제외한다.
				counter++;
				if(n % prime[i] == 0) {
					break;
				}
			}
			if(i == pnum) {					//마지막까지 나누어 떨어지지 않는다면 소수이다.
				prime[pnum++] = n;
			}
		}
		
		for(int j=0;j<pnum;j++) {
			System.out.println(prime[j]);
		}
		
		System.out.println("나눗셈 실행 횟수:"+counter);
	}

}
