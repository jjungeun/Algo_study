class ShellSort {
  public static void main(String[] args) {
    int[] arr = { 8, 1, 4, 6, 5, 2, 3, 7 };
    shellsort(arr);
    for (int a : arr)
      System.out.println(a);
  }

  public static void shellsort(int[] arr) {
    int n = arr.length;
    for (int h = n / 2; h > 0; h /= 2) {
      for (int i = h; i < n; i++) {
        int j;
        int tmp = arr[i];
        for (j = i - h; j >= 0 && arr[j] > tmp; j -= h) {
          arr[j + h] = arr[j];
        }
        arr[j + h] = tmp;
      }
    }
  }
}