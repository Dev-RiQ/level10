package 컬렉션프레임워크;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class _05반복자iterator {

	public static void main(String[] args) {

		int[] list1 = { 1, 2, 3, 4, 5, 6 };
		
		int[] list2 = list1.clone(); // clone => 깊은 복사
		System.out.println(Arrays.toString(list1));
		System.out.println(Arrays.toString(list2));
		
		list2[2] = 100;
		System.out.println(Arrays.toString(list1));
		System.out.println(Arrays.toString(list2));
		
		Set<Integer> list3 = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
//		System.out.println(list3);
//		list3.remove(3);
		System.out.println(list3);
		
		for(Integer num : list3) {
//			if(num == 3) 			// 에러
//				list3.remove(num);
			System.out.println(num);
		}
		System.out.println(list3);
		
		// Set 값 삭제 => Iterator only
		
		Iterator<Integer> iterator = list3.iterator();
//		iterator.next();
//		System.out.println(iterator.next()); // buffer 보여주면 다음으로 넘어감
//		System.out.println(iterator.next());
		
		while(iterator.hasNext())
			if(iterator.next() == 3)
				iterator.remove(); // 원래 데이터도 삭제됨
		System.out.println(list3);
		
		Map<Integer, String> list4 = new HashMap<>();
		list4.put(1, "1");
		list4.put(2, "2");
		list4.put(3, "3");
		list4.put(4, "4");
		list4.put(5, "5");
		list4.put(6, "6");
		System.out.println(list4);
		
		Iterator<Integer> keyList = list4.keySet().iterator();
		while(keyList.hasNext())
			if(keyList.next() == 2)
				keyList.remove(); // 실제 map 값 삭제 (value로 삭제 불가능)
				
		System.out.println(list4);
		
		
	}

}
