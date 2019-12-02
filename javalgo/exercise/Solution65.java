import java.util.Arrays;

class Solution65 {
  public static void main(String[] args) {
    int[] people = { 50, 70, 80 };
    System.out.println(new Solution65().solution(people, 100));
  }

  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);
    int small = 0;
    int big = people.length - 1;

    while (small <= big) {
      if (people[small] + people[big] <= limit) {
        small++;
      }
      big--;
      answer++;
    }
    return answer;
  }
}