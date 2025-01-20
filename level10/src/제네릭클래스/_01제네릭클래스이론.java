package 제네릭클래스;

class Box<T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

class TV{
	String brand;
	int serialNo;
	
	TV(String brand, int serialNo) {
		this.brand = brand;
		this.serialNo = serialNo;
	}

	@Override
	public String toString() {
		return "TV [brand=" + brand + ", serialNo=" + serialNo + "]";
	}
	
}

class Product<T , M>{
	private T kind;
	private M model;
	
	public T getKind() {
		return kind;
	}

	public M getModel() {
		return model;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}

	public void setModel(M model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Product [kind=" + kind + ", model=" + model + "]";
	}
}


public class _01제네릭클래스이론 {

	public static void main(String[] args) {

		Box<Integer> test = new Box<>();
		test.setT(123);
		System.out.println(test.getT());
		
		Box<String> test2 = new Box<>();
		test2.setT("qwer");
		System.out.println(test2.getT());
		
		Box<TV> tv = new Box<>();
		tv.setT(new TV("SAMSUNG",1001));
		System.out.println(tv.getT());
		tv.setT(new TV("LG",1002));
		System.out.println(tv.getT());
		
		Product<Integer,String> test4 = new Product<>();
		test4.setKind(1000);
		test4.setModel("모델명");
		System.out.println(test4);
		
		Product<TV,String> test5 = new Product<>();
		test5.setKind(new TV("HANSUNG",1003));
		test5.setModel("한탠바이미");
		System.out.println(test5);
	}

}
