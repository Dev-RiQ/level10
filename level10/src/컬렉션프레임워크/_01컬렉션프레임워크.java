package 컬렉션프레임워크;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class User implements Comparable<User> {
	String name;
	int age;
	User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name + ":" + age +"\n";
	}
	@Override
	public int compareTo(User o) {
//		return name.compareTo(o.name);
		if(age > o.age)
			return 1;
		else if(age < o.age)
			return -1;
		else
			return name.compareTo(o.name);
	}
	
}

public class _01컬렉션프레임워크 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list);
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		System.out.println(list2);
		@SuppressWarnings("unchecked")
		ArrayList<Integer> list3 = (ArrayList<Integer>) list2.clone();
		System.out.println(list3);
		ArrayList<User> list4 = new ArrayList<>();
		list4.add(new User("홍길동",30));
		list4.add(new User("둘리",5));
		list4.add(new User("스폰지밥",10));
		list4.add(new User("뚱이",12));
		list4.add(new User("또치",5));
		list4.add(new User("김길순",25));
		
		System.out.println(list4);
		Collections.sort(list4);
		System.out.println(list4);
	}

}
