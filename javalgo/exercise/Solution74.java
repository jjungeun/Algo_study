class Solution74 {
	public static void main(String[] args) {
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		System.out.println(new Solution74().solution(user_id, banned_id));
	}

	boolean is_fit(String user, String ban) {
		char[] user_arr = user.toCharArray();
		char[] ban_arr = ban.toCharArray();
		for (int i = 0; i < ban.length(); i++) {
			if (ban_arr[i] != '*' && user_arr[i] != ban_arr[i])
				return (false);
		}
		return (true);
	}

	public int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		for (String ban : banned_id) {
			int count = 0;
			for (String user : user_id) {
				if (ban.length() == user.length() && is_fit(user, ban))
					count++;
			}
			System.out.println(ban + " " + count);
			if (answer == 0)
				answer += count;
			else if (count != 0)
				answer *= count;
		}
		return answer;
	}
}
