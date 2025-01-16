package 상속_개념;

class D{ // extends Object 생략된것
	int d = 10;
	D(){
		System.out.println("D 생성 !!");
	}
}

class E extends D{
	int e = 20;
	E(){
		System.out.println("E 생성 !!");
	}
}

class F extends E{
	int f = 30;
	F(){
		System.out.println("F 생성 !!");
	}
}

public class _02상속2 {

	public static void main(String[] args) {
		
		F f = new F();
		System.out.println(f.d);
		System.out.println(f.e);
		System.out.println(f.f);
	}
}
