class Solution21 {
  public static void main(String[] args) {
    System.out.println(new Solution21().solution(5, new int[] { 2, 4 }, new int[] { 2 }));
  }

  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n;
    int[] arr = new int[n + 2];

    // 여유분이 있으면 +1, 잃어버렸으면 -1
    for (int r : reserve) {
      arr[r] += 1;
    }
    for (int l : lost) {
      arr[l] -= 1;
    }

    // 음수인 자리 중 앞자리가 양수거나 뒷자리가 양수면 빌리기
    for (int i = 1; i < n + 1; i++) {
      if (arr[i] < 0) {
        if (arr[i - 1] > 0) {
          arr[i] += 1;
          arr[i - 1] -= 1;
        } else if (arr[i + 1] > 0) {
          arr[i] += 1;
          arr[i + 1] -= 1;
        }
      }
    }

    // 최종적으로 answer에서 음수인 자리 개수 빼기
    for (int i = 1; i < n + 1; i++)
      answer -= arr[i] < 0 ? 1 : 0;

    return answer;
  }
}