class ShellSort {
  public static void main(String[] args) {
    int[] arr = { 8, 1, 4, 6, 5, 2, 3, 7 };
    shellsort(arr);
    for (int a : arr)
      System.out.println(a);
  }

  public static void shellsort(int[] arr) {
    int size = arr.length;
    for (int gap = size / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < size; i++) {
        int j = i;
        int tmp = arr[i];
        while (j >= gap && arr[j - gap] > tmp) {
          arr[j] = arr[j - gap];
          j -= gap;
        }
        arr[j] = tmp;
      }
    }
  }
}