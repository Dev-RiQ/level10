package 함수형프로그래밍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _05스트림개념 {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("유재석", "하하", "박명수", "정형돈", "정준하", "노홍철", "하하", "정형돈");

		System.out.println("============= 1 ============");
		for (int i = 0; i < names.size(); i++)
			System.out.println(names.get(i));
		System.out.println("============= 2 ============");
		for (String name : names)
			System.out.println(name);
		System.out.println("============= 3 ============");
		names.forEach(System.out::println);

		Stream<String> nameStream = names.stream();

		System.out.println("============= 4 ============");
		nameStream.forEach(System.out::println);
		// 최종연산 후 사라짐

		System.out.println("============= 5 ============");
		names.stream() // 스트림 객체 색성
		.distinct() // 중복 제거 (중간연산)
		.forEach(System.out::println); // 출력 (최종연산)
		
		System.out.println("============= 6 ============");
		List<String> copyName = names.stream().distinct().collect(Collectors.toList());
		System.out.println(copyName);

		System.out.println("============= 7 ============");
		List<Integer> list = new ArrayList<>(Arrays.asList(7,1,2,3,4,5,6));
		
		System.out.println(list);
		
		System.out.println("============= 8 ============");
		
		List<Integer> odds = new ArrayList<>();
		
		for(Integer odd : list)
			if(odd % 2 == 1)
				odds.add(odd);
		System.out.println(odds);
		
		Collections.sort(odds);
		System.out.println(odds);
		
		String data = "";
		for(Integer odd : odds)
			data += odd + ", ";
		data = data.substring(0,data.length()-2);
		System.out.println(data);
		
		System.out.println("============= 9 ============");
		String result = Arrays.toString(list.stream().filter(x -> x%2 == 1).sorted(Integer::compare).toArray());
		System.out.println(result);
		
	}

}
