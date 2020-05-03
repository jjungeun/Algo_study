
public class Solution84 {
	public static void main(String[] args){
		int[] nums = {1,2,7,6,4};
		System.out.println(new Solution84().solution(nums));
	}

	boolean is_prime(int sum)
	{
		for(int i = 2;i*i<=sum;i++)
			if(sum % i == 0)
				return false;
		return true;
	}

	int primeCount(int[] nums, int idx, int depth, int sum)
	{
		int count = 0;
		if (depth == 3)
			return is_prime(sum) ? 1 : 0;
		for (int i = idx + 1; i<nums.length; i++)
			count += primeCount(nums, i, depth + 1, sum + nums[i]);
		return count;
	}

    public int solution(int[] nums) {
		int answer = 0;
		for(int i=0; i<nums.length;i++)
			answer += primeCount(nums, i, 1, nums[i]);
        return answer;
    }
}
