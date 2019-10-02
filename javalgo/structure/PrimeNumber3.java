package javalgo.structure;

/* �Ҽ� ���ϴ� �˰��� - �˰��� ����2
 * � ���� n�� ���ؼ� n�� ������ ������ � �Ҽ��ε� ������ �������� ������ n�� �Ҽ��̴�.*/

public class PrimeNumber3 {

	public static void main(String[] args) {
		int counter = 0;
		int[] prime = new int[100];
		int pnum = 0;
		
		prime[pnum++] = 2;
		prime[pnum++] = 3;
		
		for(int n=5; n<100; n+=2) {					//n=5���� �����ؾ� n % prime[i]���� devision by 0 ������ ���� �ʴ´�. 
			int i;
			boolean isPrime = true;
			for(i=1;prime[i]*prime[i]<=n;i++) {
				counter +=2;						//������ ���ϱ�, ������ �ι� �Ͼ��.
				if(n % prime[i] == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				counter++;							//������ prime[i]*prime[i]�� ������ �ʾұ� ������ ���⼭ counter++���ش�.
				prime[pnum++] = n;
			}
		}
		
		for(int j=0;j<pnum;j++) {
			System.out.println(prime[j]);
		}
		
		System.out.println("����, ������ ���� Ƚ�� : "+counter);
		
	}

}
