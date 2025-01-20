package 컬렉션프레임워크;

import java.util.Comparator;
import java.util.TreeSet;

// Comparable - 자신과 다른 객체 비교
// Comparator - 주어진 두 객체 => treeSet, treeMap 에서 사용

class Person implements Comparable<Person>{

	private static int lastNo = 0;
	private int no;
	private String name;
	private int age;
	
	Person(String name, int age) {
		this.no = ++lastNo;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getNo() {
		return no;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Person o) {
//		return name.compareTo(o.name);
		if(no > o.no)
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {
		return String.format("no = %d, name = %s, age = %d \n", no,name,age);
	}
	
}

class PersonComp implements Comparator<Person> {
	enum SortBy{NO, NAME, AGE}
	enum SortDir{ASC, DESC}
	
	private SortBy sortBy;
	private SortDir sortDir;
	
	PersonComp(SortBy sortBy, SortDir sortDir) {
		this.sortBy = sortBy;
		this.sortDir = sortDir;
	}

	@Override
	public int compare(Person o1, Person o2) {
		int result = 0;
		switch(sortBy) {
		case NO: result = o1.getNo() > o2.getNo() ? 1 : -1; break;
		case NAME: result = o1.getName().compareTo(o2.getName()); break; 
		case AGE : result = o1.getAge() > o2.getAge() ? 1 : -1; break;
		}
		return result * (sortDir == sortDir.ASC ? 1 : -1);
	}
	
}

public class _06비교하기 {

	public static void main(String[] args) {

		Person[] pList = {
				new Person("홍길동", 20),
				new Person("전우치", 30),
				new Person("임꺽정", 10),
				new Person("스폰지밥", 25),
				new Person("뚱이", 15),
				new Person("개똥이", 35)
		};
		
		TreeSet<?>[] treeSets = {
			new TreeSet<>(), 
			new TreeSet<>(new PersonComp(PersonComp.SortBy.NO, PersonComp.SortDir.DESC)), 
			new TreeSet<>(new PersonComp(PersonComp.SortBy.AGE, PersonComp.SortDir.DESC)), 
			new TreeSet<>(new PersonComp(PersonComp.SortBy.NAME, PersonComp.SortDir.DESC)), 
			new TreeSet<>(new PersonComp(PersonComp.SortBy.NO, PersonComp.SortDir.ASC)), 
			new TreeSet<>(new PersonComp(PersonComp.SortBy.AGE, PersonComp.SortDir.ASC)), 
			new TreeSet<>(new PersonComp(PersonComp.SortBy.NAME, PersonComp.SortDir.ASC)), 
		};
		
		for(Person p : pList)
			for(TreeSet ts : treeSets)
				ts.add(p);
		System.out.println("==============");
		
		for(TreeSet<?> ts : treeSets) {
			for(Object o : ts)
				System.out.println(o);
			System.out.println("==============");
		}
		
	}

}
