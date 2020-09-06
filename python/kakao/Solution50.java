import java.util.*;

class Solution50 {
	ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

	public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = 0;
		for(int i = 0; i < n + 1; i++) {
            al.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edge_list.length; i++) {
            int startNode = edge_list[i][0];
            int endNode = edge_list[i][1];

            al.get(startNode).add(endNode);
            al.get(endNode).add(startNode);
		}
		answer = dp(n, k, gps_log);
		return answer;
	}

	private int dp(int n, int k, int[] gps_log) {
		int inf = 987654321;
		int[][] arr = new int[k][n+1];
		for (int i=0; i<arr.length; i++){
			Arrays.fill(arr[i], inf);
		}
		arr[0][gps_log[0]] = 0;
		for (int i=1; i<k; i++) {
			for (int j=1; j<n+1; j++) {
				arr[i][j] = Math.min(arr[i][j], arr[i-1][j]);
				for (int node: al.get(j))
					arr[i][j] = Math.min(arr[i-1][node], arr[i][j]);
				arr[i][j] += gps_log[i] == j ? 0 : 1;
			}
		}

		if (arr[k-1][gps_log[k-1]] >= inf)
			return -1;
		return arr[k-1][gps_log[k-1]];
	}

	public static void main(String[] args) {
		int n = 7;
		int m = 10;
		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3},{2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
		int k = 6;
		int[] gps_log = {1, 2, 3, 3, 6, 7};
		System.out.println(new Solution50().solution(n, m, edge_list, k, gps_log));
	}
}

// import java.util.*;

// class Solution50 {
// 	HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

// 	public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
// 		int answer = 0;
// 		for (int[] edge: edge_list) {
// 			int edge1 = edge[0];
// 			int edge2 = edge[1];
// 			map.putIfAbsent(edge1, new HashSet<>());
// 			map.get(edge1).add(edge2);
// 			map.get(edge1).add(edge1);
// 			map.putIfAbsent(edge2, new HashSet<>());
// 			map.get(edge2).add(edge1);
// 			map.get(edge2).add(edge2);
// 		}
// 		answer = dp(n, k, gps_log);
// 		map.clear();
// 		return answer;
// 	}

// 	private int dp(int n, int k, int[] gps_log) {
// 		int inf = 987654321;
// 		int[][] arr = new int[k][n+1];
// 		for (int i=0; i<arr.length; i++){
// 			Arrays.fill(arr[i], inf);
// 		}
// 		arr[0][gps_log[0]] = 0;
// 		for (int i=1; i<k; i++) {
// 			for (int j=1; j<n+1; j++) {
// 				arr[i][j] = Math.min(arr[i][j], arr[i-1][j]);
// 				for (int node: map.get(j))
// 					arr[i][j] = Math.min(arr[i-1][node], arr[i][j]);
// 				arr[i][j] += gps_log[i] == j ? 0 : 1;
// 			}
// 		}

// 		if (arr[k-1][gps_log[k-1]] >= inf)
// 			return -1;
// 		return arr[k-1][gps_log[k-1]];
// 	}

// 	public static void main(String[] args) {
// 		int n = 7;
// 		int m = 10;
// 		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3},{2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
// 		int k = 6;
// 		int[] gps_log = {1, 2, 3, 3, 6, 7};
// 		System.out.println(new Solution50().solution(n, m, edge_list, k, gps_log));
// 	}
// }
