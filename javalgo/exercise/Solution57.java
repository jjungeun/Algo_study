class Solution57 {
  public static void main(String[] args){
    System.out.println(new Solution57().solution(0,2));
  }

  long getGCD(long w, long h){
    return w == 0 ? h : getGCD(h % w, w);
  }

  long getArea(long w, long h){
    long max = Math.max(w,h);
    long min = Math.min(w,h);
    if(min == 1 || min == max){
      return max;
    } else {
      return max + min - 1;
    }
  }

	public long solution(int w,int h) {
    long gcd = getGCD(w,h);
    long answer = getArea(w/gcd, h/gcd);

		return (long)w * (long)h - answer * gcd;
	}
}