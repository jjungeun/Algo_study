import java.util.Arrays;
import java.util.Comparator;

class PhysSearch {
  static class PhysData {
    private String name;
    private int height;
    private double sight;

    public PhysData(String name, int height, double sight) {
      this.name = name;
      this.height = height;
      this.sight = sight;
    }

    public static final Comparator<PhysData> SIGHT_ORDER = new SightOrderComparator();

    private static class SightOrderComparator implements Comparator<PhysData> {
      public int compare(PhysData d1, PhysData d2) {
        return d1.sight < d2.sight ? 1 : d1.sight > d2.sight ? -1 : 0;
      }
    }
  }

  public static void main(String[] args) {
    PhysData[] data = { new PhysData("신", 165, 2.1), new PhysData("정", 170, 1.5), new PhysData("은", 160, 1.0) };

    int idx = Arrays.binarySearch(data, new PhysData("", 0, 2.1), PhysData.SIGHT_ORDER);

    if (idx < 0) {
      System.out.println("요소가 없습니다");
    } else {
      System.out.println("요소가 " + idx + "에 있습니다");
    }
  }
}