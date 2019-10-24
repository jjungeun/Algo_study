class Solution21 {
  public static void main(String[] args) {
    System.out.println(new Solution21().solution(5, new int[] { 2, 4 }, new int[] { 2 }));
  }

  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n;
    int[] arr = new int[n + 2];

    // �������� ������ +1, �Ҿ�������� -1
    for (int r : reserve) {
      arr[r] += 1;
    }
    for (int l : lost) {
      arr[l] -= 1;
    }

    // ������ �ڸ� �� ���ڸ��� ����ų� ���ڸ��� ����� ������
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

    // ���������� answer���� ������ �ڸ� ���� ����
    for (int i = 1; i < n + 1; i++)
      answer -= arr[i] < 0 ? 1 : 0;

    return answer;
  }
}