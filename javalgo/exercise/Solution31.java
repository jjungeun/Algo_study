class Solution31 {
  public static void main(String[] args) {
    System.out.println(new Solution31().solution(626331));
  }

  int collatz(int count, Double num) {
    if (count > 500)
      return -1;

    if (num % 2 != 0)
      return num == 1 ? count : collatz(count + 1, num * 3 + 1);
    else
      return collatz(count + 1, num / 2);
  }

  public int solution(int num) {
    // ���� int���� �״�� ���� �����÷ο찡 ���� double������ ĳ��Ʈ���־�� ��
    return collatz(0, (double) num);
  }
}