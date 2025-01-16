package 인터페이스;

// class AA 와 BB 는 긴밀한 관계를 가지고 있다.
// 메서드A 호출하려면 반드시 BB 있어야함

// 클래스 간 결속이 높으면 유지보수 어려움

class AA{
	void methodA(BB b) {
		System.out.println("methodA 호출");
		b.methodB();
	}
}

class BB{
	void methodB() {
		System.out.println("methodB 호출");
	}
}

class CC{
	void methodC() {
		System.out.println("methodC 호출");
	}
}


public class _03긴밀한관계 {
	public static void main(String[] args) {
		AA a = new AA();
		a.methodA(new BB());
	}
}
