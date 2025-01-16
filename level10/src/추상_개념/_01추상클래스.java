package 추상_개념;

// 클래스 설계 : 상태(state => data) , 행동(기능 => method)

// 단 하나라도 미완성된 메서드가 있으면 추상 클래스로 만들어야한다.

abstract class A{
	
	// 미완성된 메서드 => body{}가 존재하지 않는다
	abstract void printAnything();
	
	// 완성된 메서드
	void printSomething() {
		System.out.println("somthing");
	}
}

// 추상 클래스 상속 시 미완성 클래스 완성 시켜줘야함
class B extends A{

	@Override
	void printAnything() {
		System.out.println("B임");
	}

	
}

public class _01추상클래스 {

	public static void main(String[] args) {

		// 추상 클래스는 미완성이라 객체 생성 불가능
//		A a = new A();
		B b = new B();
		b.printAnything();
	}
}
