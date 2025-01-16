package 추상_개념;

public class BulgogiPizza extends Pizza {

	BulgogiPizza(int price, String brand) {
		super(price, brand, "불고기 피자");
	}

	@Override
	void putTopping() {
		System.out.println("불고기 토핑 추가");
	}

}
