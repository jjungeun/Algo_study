import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1260
// 인접 리스트로 구현함
public class Solution5 {
	static ArrayList<Integer>[] list;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		list = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}

		for (int i = 1; i < N + 1; i++) {
			Collections.sort(list[i]);
		}

		StringBuilder sb = new StringBuilder();
		check = new boolean[N + 1];
		dfs(V, sb);
		System.out.println(sb);
		check = new boolean[N + 1];
		sb = new StringBuilder();
		bfs(V, sb);
		System.out.println(sb);
	}

	public static void dfs(int start, StringBuilder sb) {
		check[start] = true;
		sb.append(start + " ");
		for (int i : list[start]) {
			if (check[i] == false) {
				dfs(i, sb);
			}
		}
	}

	public static void bfs(int start, StringBuilder sb) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		check[start] = true;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			sb.append(x + " ");
			for (int i : list[x]) {
				if (check[i] == false) {
					check[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
