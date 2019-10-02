package javalgo.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * �ڿ����ķ� ���ĵ��� ���� �迭���� �˻��ϱ�-> ���׸� �޼��带 ����Ѵ�.
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
		
		//�������� ������ ���� comparator
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
		
		//Ű�� ������������ ���ĵǾ� �ִ�.
		PhyscData[] data = {
			new PhyscData("shin", 157, 1.5),
			new PhyscData("jung", 165, 0.9),
			new PhyscData("eun", 180, 0.8)
		};
		
		System.out.print("�� cm�� ����� ã�� �ֳ���?");
		int height = sc.nextInt();
		
//		System.out.print("�÷��� ���� ����� ã�� �ֳ���?");
//		double vision = sc.nextDouble();
		
		int index = Arrays.binarySearch(data, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);
//		int index2 = Arrays.binarySearch(data, new PhyscData("", 0, vision), PhyscData.VISION_ORDER);
		
		if(index < 0) {
			System.out.println("��Ұ� �����ϴ�.");
		}
		else {
			System.out.println("data["+index+"]�� �ֽ��ϴ�.");
			System.out.println("ã�� ������ : "+data[index]);	//toString()ȣ��
		}
	}
}
