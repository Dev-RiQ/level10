package 컬렉션프레임워크;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class User2{
	String name;
	int age;
	User2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name +":"+age+"\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User2 other = (User2) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
}

public class _03set이론 {

	public static void main(String[] args) {

		// Set은 인덱스가 없기 때문에 저장 순서 지정 불가 (중복 안들어감)
		Set<Integer> list1 = new HashSet<>();
		list1.add(1);
		list1.add(1);
		list1.add(3);
		list1.add(4);
		System.out.println(list1);
		
		Set<Integer> list2 = new TreeSet<>();
		list2.add(1);
		list2.add(1);
		list2.add(3);
		list2.add(4);
		System.out.println(list2);
		
		// HashSet => 랜덤, LinkedHashSet => 넣은 순서대로, TreeSet => 오름차순
		
		Set<Integer> list3 = new HashSet<>();
		Set<Integer> list4 = new LinkedHashSet<>();
		Set<Integer> list5 = new TreeSet<>();
		
		for(int i : new int[] {20,1,3,341,53,15,316,7,58,64,753,75,5,453,243,2}) {
			list3.add(i);
			list4.add(i);
			list5.add(i);
		}
		Set<?>[] list6 = new Set[] {list3,list4,list5};
		for(Set<?> test : list6)
			System.out.println(test);
		
		Set<String> list7 = new HashSet<>();
		Set<String> list8 = new LinkedHashSet<>();
		Set<String> list9 = new TreeSet<>();
		
		for(String i : new String[] {"Fox","Banana","Apple","Java","SQL","VScode","Spring"}) {
			list7.add(i);
			list8.add(i);
			list9.add(i);
		}
		Set<?>[] list10 = new Set[] {list7,list8,list9};
		for(Set<?> test : list10)
			System.out.println(test);
		
		// Set은 Index가 없기때문에 Iterator 이용
		Iterator<String> iterator = list9.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
		
		// 주소값이 다르면 내부 값이 같아도 들어감 => Generate hashCode and equals 이용해서 설정 변수 값이 같으면 안들어가게 만들 수 있음
		Set<User2> uList = new HashSet<>();
		uList.add(new User2("철수", 30));
		uList.add(new User2("철수", 30));
		uList.add(new User2("철수", 30));
		uList.add(new User2("철수", 30));
		uList.add(new User2("철수", 30));
		uList.add(new User2("영희", 29));
		uList.add(new User2("민수", 31));
		System.out.println(uList);
		
	}

}
