class HeapSort {
  public static void main(String[] args) {
    int[] arr = { 6, 4, 1, 8, 7, 5, 3, 9, 2 };
    heapSort(arr);
    for (int a : arr)
      System.out.println(a);
  }

  static void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }

  static void downHeap(int[] arr, int left, int right) {
    int tmp = arr[left];
    int child;
    int parent;

    for (parent = left; parent < (right + 1) / 2; parent = child) {
      int cl = parent * 2 + 1;
      int cr = parent * 2 + 2;
      child = (cr <= right && arr[cr] > arr[cl]) ? cr : cl;
      if (tmp >= arr[child])
        break;
      arr[parent] = arr[child];
    }
    arr[parent] = tmp;
  }

  static void heapSort(int[] arr) {
    int n = arr.length;
    for (int i = (n - 1) / 2; i >= 0; i--) {
      downHeap(arr, i, n - 1);
    }

    for (int i = n - 1; i > 0; i--) {
      swap(arr, 0, i);
      downHeap(arr, 0, i - 1);
    }
  }
}