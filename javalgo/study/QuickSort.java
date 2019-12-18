import java.util.Stack;

class QuickSort {
  public static void main(String[] args) {
    // int[] arr = { 5, 8, 4, 2, 6, 1, 3, 9, 7 };
    int[] arr = { 10, 20, 30, 4, 5, 6, 8 };
    quickSort2(arr, 0, arr.length - 1);
    for (int a : arr)
      System.out.println(a);
  }

  static void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }

  static void quickSort1(int[] arr, int left, int right) {
    int pl = left;
    int pr = right;
    int pivot = arr[(left + right) / 2];
    while (pl <= pr) {
      while (arr[pl] < pivot)
        pl++;
      while (pivot < arr[pr])
        pr--;
      if (pl <= pr)
        swap(arr, pl++, pr--);
    }

    if (left < pr)
      quickSort1(arr, left, pr);
    if (pl < right)
      quickSort1(arr, pl, right);
  }

  static void quickSort2(int[] arr, int left, int right) {
    Stack<Integer> lstack = new Stack<>();
    Stack<Integer> rstack = new Stack<>();

    lstack.push(left);
    rstack.push(right);

    while (!lstack.isEmpty()) {
      int pl = left = lstack.pop();
      int pr = right = rstack.pop();
      int pivot = arr[(pl + pr) / 2];

      while (pl <= pr) {
        while (arr[pl] < pivot)
          pl++;
        while (pivot < arr[pr])
          pr--;
        if (pl <= pr)
          swap(arr, pl++, pr--);
      }

      // 요솟수 큰것 먼저 push -> 요솟수 작은것 먼저 pop
      if (pr - left > right - pl) {
        if (left < pr) {
          lstack.push(left);
          rstack.push(pr);
        }
        if (pl < right) {
          lstack.push(pl);
          rstack.push(right);
        }
      } else {
        if (pl < right) {
          lstack.push(pl);
          rstack.push(right);
        }
        if (left < pr) {
          lstack.push(left);
          rstack.push(pr);
        }
      }
    }
  }
}