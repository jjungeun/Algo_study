class Solution52 {
  public static void main(String[] args){
    int[] ans = new Solution52().solution(new int[] {1,2,3,2,3});
    for(int a: ans){
      System.out.println(a);
    }
  }

  public int[] solution(int[] prices) {
    int len = prices.length;
    int[] answer = new int[len];

    for(int i=0; i<len;i++){
      int count = 0;
      for(int j=i+1;j<len;j++){
        count++;
        if(prices[i] > prices[j]) break;
      }
      answer[i] = count;
    }

    return answer;
  }
}