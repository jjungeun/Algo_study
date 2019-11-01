import java.util.*;

class Solution48 {
  public static void main(String[] args) {
    System.out.println(new Solution48().solution("120"));
  }

  boolean isPrime(int num) {
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0)
        return false;
    }
    return num <= 1 ? false : true;
  }

  public void permutation(String prefix, String str, HashSet<Integer> set) {
    int n = str.length();
    if (!prefix.equals(""))
      set.add(Integer.valueOf(prefix));
    for (int i = 0; i < n; i++)
      permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);

  }

  public int solution(String numbers) {
    HashSet<Integer> set = new HashSet<>();
    permutation("", numbers, set);
    int answer = 0;

    while (set.iterator().hasNext()) {
      int a = set.iterator().next();
      set.remove(a);
      if (isPrime(a)) {
        answer++;
      }
    }

    return answer;
  }
}