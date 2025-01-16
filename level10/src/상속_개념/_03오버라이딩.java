package 상속_개념;

class Parent {
	int num = 100;

	void test1() {
		System.out.println("test1 호출 !!");
	}

	void printNum() {
		System.out.println("num = " + num);
	}
}

class Child extends Parent {
	int num = 200;

	void test2() {
		System.out.println("test2 호출 !!");
	}

	void printNum() {
		System.out.println("num = " + num);
		System.out.println("부모 num 호출 = "+super.num);
	}
	@Override
	void test1() {
		System.out.println("자식이 변경한 test1 호출 !!");
	}
}

public class _03오버라이딩 {

	public static void main(String[] args) {

		Parent p = new Parent();
		Child c = new Child();
		p.test1();
		p.printNum();
		c.test1();
		c.test2();
		c.printNum();
		c.printNum();

	}

}
