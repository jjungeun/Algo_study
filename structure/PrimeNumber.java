package structure;

/*�Ҽ��� ���ϴ� �˰���*/

public class PrimeNumber {

	public static void main(String[] args) {
		int counter =0;	//������ Ƚ��
		
		for(int n=2;n<100;n++) {
			int j;
			for(j=2;j<n;j++) {
				counter++;
				if(n % j == 0) {
					break;
				}
			}
			if(n == j) {
				System.out.println(n);
			}
		}
		
		System.out.println("������ ���� Ƚ��:"+counter);
	}

}
