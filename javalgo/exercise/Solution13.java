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
    // sort�� ���� hashmap�� string�� �ش� char�� �ֱ�
    HashMap<String, Integer> map = new HashMap<>();
    for (String s : strings) {
      map.put(s, (int) s.charAt(n));
    }
    // value�� ���ϰ� ������ key�� ���ϵ��� �������̵�
    List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        int comp = o1.getValue() - o2.getValue();
        return comp == 0 ? o1.getKey().compareTo(o2.getKey()) : comp;
      }
    });
    // ���ĵ� list���� getKey�Ͽ� answer�� �ֱ�
    Iterator<Map.Entry<String, Integer>> iter = list.iterator();
    while (iter.hasNext()) {
      answer.add(iter.next().getKey());
    }

    return answer.toArray(new String[0]);

    // -------------------------------------------------
    // best solution(ȿ������ �������� ���̵� ����)
    // �ش� �ε����� char�� string �տ� ���̰� �����ϸ� ��
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