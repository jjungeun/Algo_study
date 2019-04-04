package recursion;

import java.util.Scanner;

public class GCDArray {

	static int gcd(int x,int y) {
		if(y==0) {
			return x;
		}else {
			return gcd(y,x%y);
		}
	}
	
	// 배열의 시작점과 크기을 주면서 재귀메서드를 호출한다!
	static int gcdArray(int[] a, int start, int size) {
		if(size==1) {
			return a[start];
		}else if(size==2) {
			return gcd(a[start],a[start+1]);
		}else {
			return gcd(a[start],gcdArray(a,start+1,size-1));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a= {12,24,36,72,6};
		System.out.println("이 배열의 최대 공약수는 "+gcdArray(a,0,a.length));
	}

}
