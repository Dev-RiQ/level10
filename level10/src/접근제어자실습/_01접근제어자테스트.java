package 접근제어자실습;

import 상속_개념.AccessTest;

class Child extends AccessTest{
	int e = 50;

	Child() { // default, private 접근 불가
		a = 100;
		printAll();
	}
	
}

public class _01접근제어자테스트 {

	public static void main(String[] args) {

		Child c = new Child();
		
		c.a = 200;
		c.e = 200;
		c.printAll();
		
		AccessTest acc = new AccessTest();
		
		acc.a = 300;
		acc.printAll();
	}

}
