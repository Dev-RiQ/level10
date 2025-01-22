package 함수형프로그래밍;

import java.util.Arrays;
import java.util.List;

public class _04Rest파라미터 {

	public static int getSum(int ...nums) { // int[] nums, 몇개올지 모를떄
		int sum = 0;
		for(int i = 0 ; i<nums.length;i++)
			sum += nums[i];
		return sum;
	}
	
	public static void main(String[] args) {

		System.out.println(getSum());
		System.out.println(getSum(1));
		System.out.println(getSum(1,2));
		System.out.println(getSum(1,2,3));
		System.out.println(getSum(1,2,3,4));
		System.out.println(getSum(1,2,3,4,5));
		
		List<String> list =  Arrays.asList("강아지","고양이","사자","토끼");
		
		System.out.println("-----------");
		
		for(String element : list)
			System.out.println(element);
		
		System.out.println("-----------");
		
		list.forEach(element -> System.out.println(element));
		
		System.out.println("-----------");
		
		list.forEach(System.out::println);
	}

}
