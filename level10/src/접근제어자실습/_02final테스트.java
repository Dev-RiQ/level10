package 접근제어자실습;

final class Test{ // 상속 불가
	int num1;
	int num2;
	Test(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	
	void printNums() {
		System.out.println("num1 = "+num1);
		System.out.println("num2 = "+num2);
	}
}

class Parent{
	final int num = 10; // 원시 타입 값 변경 불가
	int num2 = 20;
	
	final void printNum() { // 오버라이딩 불가
		System.out.println(num);
	}

	@Override
	public String toString() {
		return "Parent [num=" + num + ", num2=" + num2 + "]";
	}
}

class Childs extends Parent{

	@Override
	public String toString() {
		return "Childs [num=" + num + ", num2=" + num2 + ", "+ super.toString() + "]";
	}
	
}

public class _02final테스트 {

	public static void main(String[] args) {

		Test t = new Test(100,200);
		t.printNums();
		
		final Parent p = new Parent(); // 참조 타입 새로운 개체 덮어쓰기 불가능 (주소값 고정)
//		p.num = 100;
		p.num2 = 100;
		Childs c = new Childs();
		System.out.println(c);
	}

}
