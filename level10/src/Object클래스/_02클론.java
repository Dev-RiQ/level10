package Object클래스;

class Bag{
	String contains;

	Bag(String contains) {
		this.contains = contains;
	}

	@Override
	public String toString() {
		return "[ "+contains+" ]";
	}
		
}

class Person implements Cloneable {
	String name;
	int age;
	Bag bag;
	Person(String name, int age, Bag bag) {
		this.name = name;
		this.age = age;
		this.bag = bag;
	}
	public Person clone() {
		try {
			Object obj = super.clone();
			return (Person) obj;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String toString() {
		return name+" : "+age+ "세 : " +bag;
	}
	
}

public class _02클론 {

	public static void main(String[] args) {

		Bag bag1 = new Bag("갤럭시탭");
		Bag bag2 = new Bag("맥북");
		
		Person p1 = new Person("홍길동", 10, bag1);
//		Person p2 = p1;
		Person p2 = p1.clone(); // 깊은 복사지만 내부 값은 그대로 (주소값 공유)
		p2.bag = bag2;
		p2.name = "둘리";
		System.out.println(p1);
		System.out.println(p2);
	}

}
