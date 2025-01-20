package 컬렉션프레임워크;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _04map이론 {

	public static void main(String[] args) {
		
		// 컬렉션 프레임 워크에 포함되지만 상속받지는 않음
		// key값은 중복 허용 X (배열 X) 
		 //  key  , value
		Map<String, Integer> list = new HashMap<>();
		list.put("apple", 10000);
		list.put("orange", 3000);
		list.put("melon", 20000);
		list.put("banana", 1000);
		System.out.println(list);
		list.put("apple", 4000); // key가 같으면 덮어쓰기
		System.out.println(list);
		
		System.out.println(list.get("banana"));
		
		Set<String> keys= list.keySet();
		System.out.println(keys);
		
		for(String s : keys)
			System.out.println(s);
		
		System.out.println(list.containsKey("orange"));
		System.out.println(list.containsKey("grape"));
		System.out.println(list.containsValue(3000));
		System.out.println(list.containsValue(5000));
		
		Set<Map.Entry<String, Integer>> list2 = list.entrySet();
		System.out.println(list2);
		for(Map.Entry<String, Integer> entry : list2)
			System.out.println(entry);
	}
}
