package 추상_개념;

public class SweetPotatoPizza extends Pizza{

	SweetPotatoPizza(int price, String brand) {
		super(price, brand, "고구마 피자");
	}

	@Override
	void putTopping() {
		System.out.println("고구마 토핑 추가");
	}

}
