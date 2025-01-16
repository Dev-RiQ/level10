package 추상_개념;

public class PineApplePizza extends Pizza{

	PineApplePizza(int price, String brand) {
		super(price, brand, "파인애플 피자");
	}

	@Override
	void putTopping() {
		System.out.println("파인애플 토핑 추가");
	}

}
