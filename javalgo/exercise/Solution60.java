class Solution60 {
  public static void main(String[] args){
    System.out.println(new Solution60().solution("BBAAAAAAB"));
  }

  int getDist(int a, int b, int len){
    return Math.abs(a-b) < len - Math.abs(a-b) ? Math.abs(a-b) : len - Math.abs(a-b);
  }

  int getIdx(char[] arr, int idx){
    int closeidx = 0;
    int closelen = arr.length;
    for(int i=0; i<arr.length;i++){
      if(arr[i] != 'A'){
        int tmplen = getDist(idx, i, arr.length);
        if(tmplen < closelen){
          closeidx = i;
          closelen = tmplen;
        }
      }
    }
    return closeidx;
  }

  public int solution(String name) {
    int answer = 0;
    int charA = (int)'A';
    int charZ = (int)'Z';
    char[] arr = name.toCharArray();

    // 상하움직임
    for(char c: arr){
      answer += c <= (charZ-charA)/2 + charA ? (int)c - charA : charZ - (int)c + 1;
    }
    
    // 좌우움직임
    int idx = 0;
    while(true){
      arr[idx] = 'A';
      int nextIdx = getIdx(arr, idx);
      if(nextIdx==0) break;
      answer += getDist(idx, nextIdx, arr.length);
      idx = nextIdx;
    }

    return answer;
  }
}