import java.util.HashSet;

class Solution81 {
	public static void main(String[] args){
		int[] nums = {3,3,2,1};
		System.out.println(new Solution81().solution(nums));
	}

    public int solution(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();

		for(int i=0; i<nums.length;i++)
			set.add(Integer.valueOf(nums[i]));

        return set.size() >=  nums.length / 2 ?  nums.length / 2 : set.size();
    }
}
