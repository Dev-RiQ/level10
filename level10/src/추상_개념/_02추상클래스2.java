package 추상_개념;

class Parent{
	int a;
	int b;
}

class Child extends Parent{
	int c;
	String d;
}

public class _02추상클래스2 {

	public static void main(String[] args) {

		// casting => 형변환
		
		// 강제 형변환
		System.out.println((int)10.2345); // 10
		
		Parent p = new Parent();
		Child c = new Child();
		// 업캐스팅 (upcasting) => 하위 클래스가 상위타입 전환 (자식객체->부모객체)
		Parent pc = new Child(); // 상위 클래스 객체만 사용가능
		
		System.out.println(p);
		System.out.println(c);
		
		// 다운캐스팅 (downcasting)
//		Child cp = new Parent(); 불가능
		Child cp = (Child) pc;
		
		System.out.println(cp);
	}

}
