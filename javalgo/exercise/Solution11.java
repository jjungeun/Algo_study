import java.util.ArrayList;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/17522
public class Solution11 {
  public static void main(String[] args) {
    int point = 2;
    int[][] arr = {{0,2}, {3,0}, {-10,0}, {0,23}, {0,-162}, {0,11}, {-235,0}, {-200,0}, {32,0}, {0,789}};
    // int point = 5;
    // int[][] arr = {{0,0}, {0,23}, {34,0}, {1,-21}, {-74,1}};
    Solution11 sol = new Solution11();
    sol.solution(point, arr);
  }

	public double solution(int point, int [][]arr) {
    ArrayList<Integer> x = new ArrayList<>();
    ArrayList<Integer> y = new ArrayList<>();
    double ans = 0;

    // 절대값 작은 쪽으로 계산
    for(int i[]: arr){
      if (Math.abs(i[0]) <= Math.abs(i[1])) {
        x.add(i[0]);
      } else {
        y.add(i[1]);
      }
    }

    //중복 제거
    x = (ArrayList)x.stream().distinct().collect(Collectors.toList());
    y = (ArrayList)x.stream().distinct().collect(Collectors.toList());
    
    // 축 구하기
    double xl = (double)x.stream().mapToInt(i->i).sum() / x.size();
    double yl = (double)y.stream().mapToInt(i->i).sum() / y.size();
    
    // 최소 value 구하기
    for(int i=0; i<x.size(); i++) {
      if(Math.abs(x.get(i)-xl) > ans){
        ans = Math.abs(x.get(i)-xl);
      }
    }
    for(int i=0; i<y.size(); i++) {
      if(Math.abs(y.get(i)-yl) > ans){
        ans = Math.abs(y.get(i)-yl);
      }
    }
    System.out.println(ans);
    return ans;
	}
}