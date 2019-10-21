import java.util.*;

class Solution13 {
  public static void main(String[] args) {
    String[] strings = { "abce", "caf", "abcd", "cdx" };
    int n = 1;
    Solution13 sol = new Solution13();
    sol.solution(strings, n);
  }

  public String[] solution(String[] strings, int n) {
    ArrayList<String> answer = new ArrayList<>();
    // sort를 위해 hashmap에 string과 해당 char값 넣기
    HashMap<String, Integer> map = new HashMap<>();
    for (String s : strings) {
      map.put(s, (int) s.charAt(n));
    }
    // value로 비교하고 같은면 key로 비교하도록 오버라이드
    List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        int comp = o1.getValue() - o2.getValue();
        return comp == 0 ? o1.getKey().compareTo(o2.getKey()) : comp;
      }
    });
    // 정렬된 list에서 getKey하여 answer에 넣기
    Iterator<Map.Entry<String, Integer>> iter = list.iterator();
    while (iter.hasNext()) {
      answer.add(iter.next().getKey());
    }

    return answer.toArray(new String[0]);

    // -------------------------------------------------
    // best solution(효율성은 안좋지만 아이디어가 좋음)
    // 해당 인덱스의 char를 string 앞에 붙이고 정렬하면 끝
    // -------------------------------------------------
    // String[] answer = {};
    // ArrayList<String> list = new ArrayList<>();
    // for (String s : strings) {
    // list.add(s.charAt(n) + s);
    // }

    // Collections.sort(list);

    // answer = new String[list.size()];
    // for (int i = 0; i < list.size(); i++) {
    // answer[i] = list.get(i).substring(1);
    // }
    // return answer;
  }
}