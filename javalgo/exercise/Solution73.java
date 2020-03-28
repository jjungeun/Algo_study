import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution73 {
	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		int[] arr = new Solution73().solution(s);
		for (int a : arr)
			System.out.println(a);
	}

	public int[] solution(String s) {
		ArrayList<Integer[]> list = new ArrayList<>();
		char[] arr = s.toCharArray();
		for (int i = 1; i < s.length() - 1;) {
			int len = 1;
			int idx = i;
			for (int j = i + 1; arr[j] != '}'; j++) {
				if (arr[j] == ',')
					len++;
				i = j + 1;
			}
			list.add(get_set(arr, idx, len));
			i += 2;
		}
		Collections.sort(list, new AscendingSize());
		return return_set(list);
	}

	boolean is_contain(int[] arr, int len, int num) {
		for (int i = 0; i < len; i++) {
			if (arr[i] == num)
				return (true);
		}
		return (false);
	}

	int[] return_set(ArrayList<Integer[]> list) {
		int len = list.get(list.size() - 1).length;
		int[] ans = new int[len];
		int ans_idx = 0;
		for (Integer[] tmp : list) {
			for (int i = 0; i < tmp.length; i++) {
				if (!is_contain(ans, ans_idx, tmp[i]))
					ans[ans_idx++] = tmp[i];
			}
		}
		return (ans);
	}

	int atoi(char[] arr, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum *= 10;
			sum += arr[i] - '0';
		}
		return (sum);
	}

	Integer[] get_set(char[] arr, int idx, int len) {
		Integer[] ret = new Integer[len];
		int ret_idx = 0;
		int start = idx + 1;
		while (true) {
			if (arr[idx] == ',' || arr[idx] == '}') {
				ret[ret_idx++] = atoi(arr, start, idx);
				start = idx + 1;
				if (arr[idx] == '}')
					break;
			}
			++idx;
		}
		return (ret);
	}

}

class AscendingSize implements Comparator<Integer[]> {
	@Override
	public int compare(Integer[] a, Integer[] b) {
		return a.length - b.length;
	}
}
