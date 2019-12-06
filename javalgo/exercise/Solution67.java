class Solution67 {
  public static void main(String[] args) {
    System.out.println(new Solution67().solution(new int[] { 1, 1, 1, 1, 2 }, 2));
  }

  int dfs(int[] numbers, int n, int sum, int target) {
    if (n == numbers.length) {
      return sum == target ? 1 : 0;
    }

    return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
  }

  public int solution(int[] numbers, int target) {
    int answer = dfs(numbers, 0, 0, target);

    return answer;
  }
}