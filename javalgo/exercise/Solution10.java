import java.util.*;
// ���� ���ڴ� �Ⱦ�
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
    // �ϴ��� �ڵ�� return answer.stream().mapToInt(i->i).toArray()�� ����
    // ���� ǥ���� �� �����ϳ� �Ʒ� �ڵ尡 ȿ������ �ξ� ���� ������
    // ArrayList => Array �� �� ������ ���� �ϱ�
    // ------------------------------------------------------------------
    int[] ans = new int[answer.size()];
    for(int i=0; i<ans.length; i++) {
      ans[i] = answer.get(i).intValue();
    }
    return ans;
	}
}