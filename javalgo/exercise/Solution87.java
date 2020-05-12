import java.util.*;

public class Solution87 {
	public static void main(String[] args)
	{
		String str1 = "FRANCE";
		String str2 = "french";
		System.out.println(new Solution87().solution(str1, str2));
	}

	boolean is_char(char c)
	{
		return c >= 'A' && c <= 'Z' ? true : false;
	}

	HashMap<String, Integer> jset(String str)
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		char[] arr = new char[2];
		for(int i=0; i < str.length() - 1; i++)
		{
			arr[0] = Character.toUpperCase(str.charAt(i));
			arr[1] = Character.toUpperCase(str.charAt(i + 1));
			if (is_char(arr[0]) && is_char(arr[1]))
			{
				String jc = String.copyValueOf(arr);
				if(map.containsKey(jc))
					map.put(jc, map.get(jc) + 1);
				else
					map.put(jc, 1);
			}
		}
		return map;
	}

	public int solution(String str1, String str2) {
		HashMap<String, Integer> map1 = jset(str1);
		HashMap<String, Integer> map2 = jset(str2);
		int inter = 0;
		int union = 0;

		Iterator<String> iter = map1.keySet().iterator();
		while(iter.hasNext())
		{
			String str = iter.next().toString();
			if (map2.containsKey(str))
			{
				inter += Math.min(map1.get(str), map2.get(str));
				union += Math.max(map1.get(str), map2.get(str));
				map2.remove(str);
			}
			else
				union += map1.get(str);
		}
		iter = map2.keySet().iterator();
		while(iter.hasNext())
			union += map2.get(iter.next().toString());
		return union == 0 ? 65536 : (int)((float)inter/union * 65536);
    }
}
