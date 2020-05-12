import java.util.HashSet;

public class Solution86 {
	public static void main(String[] args)
	{
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] ans = new Solution86().solution(n, words);
		for(int a: ans)
			System.out.println(a);
	}
	public int[] solution(int n, String[] words) {
		char pre = ' ';
		HashSet<String> set = new HashSet<String>();

		for(int i = 0; i < words.length; i++)
		{
			String word = words[i];
			if (pre != ' ' && (pre != word.charAt(0) || set.contains(word)))
				return new int[] {i % n + 1, i / n + 1};
			pre = word.charAt(word.length() - 1);
			set.add(word);
		}
        return new int[] {0,0};
    }
}
