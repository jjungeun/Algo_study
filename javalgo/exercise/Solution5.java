import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1260
// https://mygumi.tistory.com/102
public class Solution5{
  static ArrayList<Integer>[] list;
	static boolean[] check;
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		list = (ArrayList<Integer>[])new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		for(int i=1; i<N+1; i++) {
			Collections.sort(list[i]);
		}
		StringBuilder sb = new StringBuilder();
		check = new boolean[N+1];
		dfs(V, sb);
		System.out.println(sb);
//		System.out.println();
		check = new boolean[N+1];
		sb = new StringBuilder();
		bfs(V , sb);
		System.out.println(sb);
	}
	public static void dfs(int start, StringBuilder sb) {
		
		check[start] = true;
		sb.append(start +" ");
		for(int i: list[start]) {
			if(check[i]==false) {
				dfs(i, sb);
			}
		}
	}
	public static void bfs(int start, StringBuilder sb) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		check[start] = true;
//		System.out.println(start+ " ");
		while(!queue.isEmpty()) {
			int x = queue.poll();
			sb.append(x+" ");
			for(int i:list[x]) {
//				System.out.println(x + " ");
				if(check[i]==false) {
					check[i] = true;
					queue.add(i);
				}
			}
		}
	}
  // public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	StringTokenizer st = new StringTokenizer(br.readLine());

  //   int n = Integer.parseInt(st.nextToken());
  //   int m = Integer.parseInt(st.nextToken());
  //   int start = Integer.parseInt(st.nextToken());

  //   ArrayList<Integer>[] a = new ArrayList[n+1];
  //   for (int i=0; i<n; i++) {
  //     a[i] = new ArrayList<>();
  //   }
    
  //   for (int i=0; i<m; i++) {
  //     st = new StringTokenizer(br.readLine());
  //     int v1 = Integer.parseInt(st.nextToken());
  //     int v2 = Integer.parseInt(st.nextToken());

  //     a[v1].add(v2);
  //     a[v2].add(v1);
  //   }

  //   // 인접리스트 정렬
  //   for (int i=1; i<=n; i++){
  //     Collections.sort(a[i]);
  //   }

  //   boolean[] c = new boolean[n + 1];
  //   dfs(a, c, start);
  //   System.out.println();
  //   Arrays.fill(c, false);
  //   bfs(a, c, start);
  // }

  // public static void dfs(ArrayList<Integer>[] a, boolean[] c, int start) {
  //   System.out.println(a);
  // }

  // public static void bfs(ArrayList<Integer>[] a, boolean[] c, int start){

  // }
}
