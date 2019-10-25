class Solution27 {
  public static void main(String[] args) {
    System.out.println(new Solution27().solution(120));
  }

  public long solution(long n) {
    long sqrtNum = (long) Math.sqrt(n);
    if (Math.pow(sqrtNum, 2) == n) {
      return (long) Math.pow(sqrtNum + 1, 2);
    }
    return -1;
  }
}