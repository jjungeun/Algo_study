import java.util.*;
// 나누어 떨어지는 숫자 배열
class Solution9 {
  public static void main(String[] args) {
    int[] arr = {6,9,7,11};
    int divisor = 5;
    Solution9 sol = new Solution9();
    sol.solution(arr, divisor);
  }
  public int[] solution(int[] arr, int divisor) {
      ArrayList<Integer> answer = new ArrayList<Integer>();
      for(int i=0;i<arr.length;i++){
        if(arr[i] % divisor == 0){
          answer.add(arr[i]);
        }
      }

      if (answer.size() == 0){
        return new int[] {-1};
      }
      
      int[] ans = answer.stream().mapToInt(i->i).toArray();
      Arrays.sort(ans);
      return ans;
  }
}