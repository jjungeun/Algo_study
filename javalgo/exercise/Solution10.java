import java.util.*;
// 같은 숫자는 싫어
public class Solution10 {
  public static void main(String[] args) {
    int[] arr = {1,1,3,3,0,1,1};
    Solution10 sol = new Solution10();
    sol.solution(arr);
  }
	public int[] solution(int []arr) {
    ArrayList<Integer> answer = new ArrayList<Integer>();
    int pre = -1;
    for(int i=0; i<arr.length; i++) {
      if (arr[i] != pre){
        answer.add(arr[i]);
        pre = arr[i];
      }
    }

    // ------------------------------------------------------------------
    // 하단의 코드는 return answer.stream().mapToInt(i->i).toArray()와 같음
    // 위의 표현이 더 간결하나 아래 코드가 효율성이 훨씬 좋기 때문에
    // ArrayList => Array 할 땐 다음과 같이 하기
    // ------------------------------------------------------------------
    int[] ans = new int[answer.size()];
    for(int i=0; i<ans.length; i++) {
      ans[i] = answer.get(i).intValue();
    }
    return ans;
	}
}