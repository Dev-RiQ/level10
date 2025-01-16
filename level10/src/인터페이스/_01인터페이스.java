package 인터페이스;

// 추상클래스 vs 인터페이스

// 인터페이스 : 다중 상속이 목적, 객체 따로 못만듬, 객체 생성이 목적아님

// 추상클래스 : 동물 식물 기계
// 인터페이스 : movable() flyable() eatable() swimable() aboardable()

// 자동차 구현 => 기계 => movable(), aboardable()
// 새 => 동물 => movable(), flyable(), eatable(), swimable()
// 사람 => 동물 => movable(), swimable(), eatable()
// 오리배 => 기계 => movable(),swimable(), aboardable()
// 연꽃 => 식물 => swimable()

/*
 				추상클래스				|				인터페이스
 	개념 | 물려 받는 것(혈통,가문,계열) | 장착한다(기능,행위,학위,자격증)
 다중적용| 불가능 (부모는 하나)         | 가능
 생성자  | 가능                         | 불가능
 메서드  | 모두 가능					| static / default 외 미완성  
 멤버변수| 모두 가능					| public final static로 생성됨 
 적용	 | extends	(확장 )				| implements (구현)
 */

class A{
	int num = 10;
	final static int num2 = 10;
}

abstract class B{
	int num = 10;
	abstract void init();
}

// 추상클래스보다 더 추상적 => 여러개를 상속하려고
// 모든 멤버 변수는 상수 (public final static)
// 모든 클래스는 미완성 (public abstract) => static/default 아닌 완성품 못만듬
interface C{
	int num = 10; // public static final (생략됨)
	void test1(); // public abstract (생략됨)
	static void test2() {
		
	}
}

interface D{
	void test2();
}

class E extends A implements C, D{

	@Override
	public void test2() {
		
	}

	@Override
	public void test1() {
		
	}
	
}

interface F extends D { // interface 끼리는 extends (implements X)
	
}

public class _01인터페이스 {

	public static void main(String[] args) {

		
	}

}
