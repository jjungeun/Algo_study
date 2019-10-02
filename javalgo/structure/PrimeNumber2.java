package javalgo.structure;

/* �Ҽ� ���ϴ� �˰��� - �˰��� ����1
 * 2�̻��� ¦���� �Ҽ��� �ƴϰ�, Ȧ������ �Ҽ����� ����� �ƴ϶�� �Ҽ��̴�. */

public class PrimeNumber2 {

	public static void main(String[] args) {
		int counter = 0; //������ Ƚ��
		int[] prime = new int[100];	//�Ҽ��� �迭
		int pnum = 0; //�Ҽ��� ����
		
		prime[pnum++] = 2;	//2�� �Ҽ��̴�.
		
		for(int n=3;n<100;n+=2) {			//¦���� �����ϰ� Ȧ���� �����Ѵ�.
			int i;
			for(i=1;i<pnum;i++) {			//2�̻��� �Ҽ��� ��� Ȧ���̹Ƿ� 2�� ������ ���� �����Ѵ�.
				counter++;
				if(n % prime[i] == 0) {
					break;
				}
			}
			if(i == pnum) {					//���������� ������ �������� �ʴ´ٸ� �Ҽ��̴�.
				prime[pnum++] = n;
			}
		}
		
		for(int j=0;j<pnum;j++) {
			System.out.println(prime[j]);
		}
		
		System.out.println("������ ���� Ƚ��:"+counter);
	}

}
