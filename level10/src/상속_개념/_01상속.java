package 상속_개념;

// 객체지향 OOP (Object Oriented programming)
// 영화를 예매한다 -> 영화관, 좌석, 유저, 영화, ...

// 객체가 유지가적으로 존재해서 상호작용 (메서드 호출, 리턴값 받아오기) => 시스템 구현

// 1. 캡슐화(encapsulation) : 객체를 독립적으로 만든다. private 필드 + getter + setter
// 2. 상속(inheritance) : 자식 클래스가 부모 클래스의 속성(필드 + 메서드)을 상속받는다
// 3. 추상화(abstract) : <-> 구체화 / 미완성된 메서드가 있으면 추상클래스
// 4. 다형성(polymorphism) :  다양한 + 형태 => 여러 자식클래스들을 하나의 부모 타입으로 묶을 수 있다
	// upcasting, downcasting, 추상클래스, 인터페이스

class A{
	int a = 10;
	int b = 20;
	A(){
		System.out.println("A 생성됨!!!");
	}
}

class B{
	A a;
	int c = 30;
	int d = 40;
	B(){
		a = new A();
		System.out.println("B 생성됨!!!");
	}
}

class C extends A{
	int e = 50;
	int f = 60;
	C(){
		// super(); 먼저 부모를 생성한다 (extends 면 자동으로 먼저 생성) => 생략되어있음
		System.out.println("C 생성됨!!!");
	}
	C(int e, int f) {
		//this();
		this.e = e;
		this.f = f;
	}
	
}

// 상속받은 자식클래스
// 1. 부모클래스의 필드나 메서드를 바로 접근가능
// 2. 상속은 단 한개만 허용

public class _01상속 {

	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.c);
		System.out.println(b.d);
		System.out.println(b.a.a);
		System.out.println(b.a.b);
		System.out.println("===========");
		C c = new C(100,200);
		System.out.println(c.e);
		System.out.println(c.f);
		System.out.println(c.a);
		System.out.println(c.b);
	}
}
