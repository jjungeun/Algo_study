class BubbleSort {
  public static void main(String[] args) {
    int[] arr = { 6, 5, 9, 4, 2, 1, 8, 3, 7 };
    bubbleSort4(arr);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  static void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }

  // version 1
  static void bubbleSort1(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len - 1; i++) {
      for (int j = len - 1; j > i; j--) {
        if (arr[j - 1] > arr[j]) {
          swap(arr, j - 1, j);
        }
      }
    }
  }

  // version 2
  static void bubbleSort2(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len - 1; i++) {
      int chg = 0;
      for (int j = len - 1; j > i; j--) {
        if (arr[j - 1] > arr[j]) {
          swap(arr, j - 1, j);
          chg++;
        }
      }
      if (chg == 0)
        break;
    }
  }

  // version 3
  static void bubbleSort3(int[] arr) {
    int len = arr.length;
    int k = 0;
    while (k < len - 1) {
      int last = len - 1;
      for (int j = len - 1; j > k; j--) {
        if (arr[j - 1] > arr[j]) {
          swap(arr, j - 1, j);
          last = j;
        }
      }
      k = last;
    }
  }

  // version 4
  static void bubbleSort4(int[] arr) {
    int last = arr.length - 1;
    int first = 0;
    int turn = 0;
    while (first < last) {
      if (turn % 2 == 0) {
        for (int j = first + 1; j < last; j++) {
          if (arr[j - 1] > arr[j]) {
            swap(arr, j - 1, j);
          }
        }
        last--;
      } else {
        for (int j = last; j > first; j--) {
          if (arr[j - 1] > arr[j]) {
            swap(arr, j - 1, j);
          }
        }
        first++;
      }
      turn++;
    }
  }
}