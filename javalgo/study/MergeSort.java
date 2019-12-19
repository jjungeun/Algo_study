class MergeSort {
  public static void main(String[] args) {
    int[] arr = { 3, 8, 2, 9, 7, 1, 6, 4, 5 };
    mergeSort(arr, 0, arr.length - 1);
    for (int a : arr)
      System.out.println(a);
  }

  static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      int[] buff = new int[right - left + 1];
      int center = (left + right) / 2;

      mergeSort(arr, left, center);
      mergeSort(arr, center + 1, right);

      int i = 0;
      int pl = left;
      int pr = center + 1;
      while (i + left <= right) {
        if (pl > center) {
          buff[i++] = arr[pr++];
          continue;
        } else if (pr > right) {
          buff[i++] = arr[pl++];
          continue;
        }
        if (arr[pl] <= arr[pr]) {
          buff[i++] = arr[pl++];
        } else {
          buff[i++] = arr[pr++];
        }
      }

      int idx = 0;
      for (int j = left; j <= right; j++) {
        arr[j] = buff[idx++];
      }
    }
  }
}