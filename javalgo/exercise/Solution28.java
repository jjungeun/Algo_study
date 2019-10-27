import java.util.*;

class Solution28 {
  public static void main(String[] args) {
    int[] ans = new Solution28().solution(new int[] { 4, 3, 5, 1 });
    for (int i = 0; i < ans.length; i++)
      System.out.println(ans[i]);
  }

  public int[] solution(int[] arr) {
    ArrayList<Integer> answer = new ArrayList<>();
    int min = (int) Double.POSITIVE_INFINITY;

    if (arr.length == 1)
      return new int[] { -1 };

    for (int i = 0; i < arr.length; i++) {
      answer.add(arr[i]);
      min = arr[i] < min ? arr[i] : min;
    }
    answer.remove(answer.indexOf(min));

    return answer.stream().mapToInt(i -> i).toArray();
  }
}