import java.util.Arrays;
import java.util.Comparator;

class Solution77 {
	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		int[] ans = new Solution77().solution(s);
		for (int a : ans)
			System.out.println(a);
	}

	int get_tuple_size(String s, int start_idx) {
		int size = 0;
		int count = 0;
		int idx = start_idx;

		while (idx < s.length()) {
			if (s.charAt(idx) == '{')
				count++;
			else if (s.charAt(idx) == '}')
				count--;
			if (count == 0)
				break;
			if (count == 1 && s.charAt(idx) == ',')
				size++;
			++idx;
		}
		return size + 1;
	}

	int atoi(String s, int idx) {
		int num = 0;
		while (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
			num *= 10;
			num += s.charAt(idx) - '0';
			++idx;
		}
		return num;
	}

	int get_digit(int num) {
		int digit = 1;
		while (num / 10 > 0) {
			++digit;
			num /= 10;
		}
		return digit;
	}

	int stringToArr(int[][] tuples, int tuple_idx, String s, int start_idx) {
		int endIndex = start_idx + 1;
		int num_idx = 0;
		tuples[tuple_idx] = new int[get_tuple_size(s, start_idx)];
		for (int i = start_idx + 1; i < s.length() - 1;) {
			if (s.charAt(i) == '}') {
				endIndex = i;
				break;
			} else if (s.charAt(i) != ',') {
				tuples[tuple_idx][num_idx] = atoi(s, i);
				i += get_digit(tuples[tuple_idx][num_idx]);
				num_idx++;
			} else
				i++;
		}
		return endIndex;
	}

	boolean not_contain(int[] arr, int arr_len, int num) {
		for (int i = 0; i < arr_len; i++)
			if (arr[i] == num)
				return false;
		return true;
	}

	public int[] solution(String s) {
		int tuple_size = get_tuple_size(s, 0);
		int[] answer = new int[tuple_size];
		int ans_idx = 0;
		int[][] tuples = new int[tuple_size][];
		int tuple_idx = 0;

		for (int i = 1; i < s.length() - 1;) {
			if (s.charAt(i) == '{') {
				i = stringToArr(tuples, tuple_idx++, s, i) + 2;
			}
		}
		Arrays.sort(tuples, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return arr1.length - arr2.length;
			}
		});
		for (int i = 0; i < tuple_idx; i++) {
			for (int j = 0; j < tuples[i].length; j++) {
				if (not_contain(answer, ans_idx, tuples[i][j]))
					answer[ans_idx++] = tuples[i][j];
			}
		}
		return answer;
	}
}
