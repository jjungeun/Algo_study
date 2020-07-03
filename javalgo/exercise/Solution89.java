import java.util.*;

public class Solution89 {
	public static void main(String[] args)
	{
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] ans = new Solution89().solution(genres, plays);
		for (int a: ans)
			System.out.println(a);
	}

	HashMap<String, HashMap<Integer, Integer>> init(String[] genres, int[] plays) {
		HashMap<String, HashMap<Integer, Integer>> genremap = new HashMap<>();
		for(int i = 0; i < genres.length; i++){
			if (genremap.get(genres[i]) == null) {
				HashMap<Integer, Integer> playmap = new HashMap<>();
				playmap.put(i, plays[i]);
				genremap.put(genres[i], playmap);
			} else {
				genremap.get(genres[i]).put(i, plays[i]);
			}
		}
		return genremap;
	}

    public int[] solution(String[] genres, int[] plays) {
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<String, HashMap<Integer, Integer>> genremap = init(genres, plays);

		//genere정렬
		HashMap<String, Integer> sortGenre = new HashMap<>();
		for(int i=0; i<genres.length;i++){
			if (!sortGenre.containsKey(genres[i])){
				sortGenre.put(genres[i], plays[i]);
			} else {
				int sum = sortGenre.get(genres[i]) + plays[i];
				sortGenre.put(genres[i], sum);
			}
		}
		List<String> keyList = new ArrayList<String>(genremap.keySet());
		Collections.sort(keyList, (o1, o2) -> (sortGenre.get(o2).compareTo(sortGenre.get(o1))));

		// play정렬
		for(int i=0;i<keyList.size();i++){
			String genre = keyList.get(i);
			HashMap<Integer, Integer> playMap = genremap.get(genre);
			List<Integer> key = new ArrayList<>(playMap.keySet());
			Collections.sort(key, (o1, o2) -> (playMap.get(o2).compareTo(playMap.get(o1))));
			answer.add(key.get(0));
			if(key.size() > 1)
				answer.add(key.get(1));
		}
		return answer.stream().mapToInt(i -> i).toArray();
	}
}
