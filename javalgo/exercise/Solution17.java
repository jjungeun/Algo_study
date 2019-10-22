import java.util.*;

class Solution17 {
  public static void main(String[] args) {
    System.out.println(new Solution17().solution(10));
  }

  public int solution(int n) {
    // -------------------------------------
    // 나누는 수를 sqrt(i)로 계산한것이 포인트이다.
    // -------------------------------------
    int answer = 0;
    
    for(int i=2; i<=n; i++){
      boolean isPrime = true;
      for(int j=2; j<=Math.sqrt(i); j++){
        if(i % j == 0){
          isPrime = false;
          break;
        }
      }
      if(isPrime) answer++;
    }
    return answer;

    // -------------------------------------
    // other solution (에라토스테네스의 체)
    // 소수의 배수들을 0으로 만든다.
    // -------------------------------------
    // int answer = 0;
    
    // int[] number = new int[n+1];
    
    // for(int i=2; i<=n; i++) {
    //     number[i] = i;
    // }

    // for(int i=2; i<=n; i++) {
    //     if(number[i]==0) continue;
        
    //     for(int j= 2*i; j<=n; j += i) {
    //         number[j] = 0;
    //     }
    // }
    
    // for(int i=0; i<number.length; i++) {
    //     if(number[i]!=0) {
    //         answer++;
    //     }
    // }
    
    // return answer;
  }
}