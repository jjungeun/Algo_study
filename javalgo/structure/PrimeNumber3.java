package javalgo.structure;

/* 소수 구하는 알고리즘 - 알고리즘 개선2
 * 어떤 정수 n에 대해서 n의 제곱근 이하의 어떤 소수로도 나누어 떨어지지 않으면 n은 소수이다.*/

public class PrimeNumber3 {

	public static void main(String[] args) {
		int counter = 0;
		int[] prime = new int[100];
		int pnum = 0;
		
		prime[pnum++] = 2;
		prime[pnum++] = 3;
		
		for(int n=5; n<100; n+=2) {					//n=5부터 시작해야 n % prime[i]에서 devision by 0 오류가 나지 않는다. 
			int i;
			boolean isPrime = true;
			for(i=1;prime[i]*prime[i]<=n;i++) {
				counter +=2;						//연산이 곱하기, 나누기 두번 일어난다.
				if(n % prime[i] == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				counter++;							//마지막 prime[i]*prime[i]가 계산되지 않았기 때문에 여기서 counter++해준다.
				prime[pnum++] = n;
			}
		}
		
		for(int j=0;j<pnum;j++) {
			System.out.println(prime[j]);
		}
		
		System.out.println("곱셈, 나눗셈 실행 횟수 : "+counter);
		
	}

}
