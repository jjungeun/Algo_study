package javalgo.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 자연정렬로 정렬되지 않은 배열에서 검색하기-> 제네릭 메서드를 사용한다.
 */

public class PhysExamSearch {
	
	static class PhyscData{
		private String name;
		private int height;
		private double vision;
		
		public PhyscData(String name,int height,double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		
		public String toString() {
			return name+" "+height+" "+vision;
		}
		
		//오름차순 정렬을 위한 comparator
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhyscData>{
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
			}
		}
		
		public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();
		
		private static class VisionOrderComparator implements Comparator<PhyscData>{
			public int compare(PhyscData d1,PhyscData d2) {
				return (d1.vision < d2.vision) ? 1: (d1.vision > d2.vision) ? -1 : 0;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//키의 오름차순으로 정렬되어 있다.
		PhyscData[] data = {
			new PhyscData("shin", 157, 1.5),
			new PhyscData("jung", 165, 0.9),
			new PhyscData("eun", 180, 0.8)
		};
		
		System.out.print("몇 cm인 사람을 찾고 있나요?");
		int height = sc.nextInt();
		
//		System.out.print("시력이 몇인 사람을 찾고 있나요?");
//		double vision = sc.nextDouble();
		
		int index = Arrays.binarySearch(data, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);
//		int index2 = Arrays.binarySearch(data, new PhyscData("", 0, vision), PhyscData.VISION_ORDER);
		
		if(index < 0) {
			System.out.println("요소가 없습니다.");
		}
		else {
			System.out.println("data["+index+"]에 있습니다.");
			System.out.println("찾은 데이터 : "+data[index]);	//toString()호출
		}
	}
}
