package 추상_개념;

import java.util.ArrayList;

public class MainPizza {

	public static void main(String[] args) {

		PizzaService service = new PizzaService();
		
		ArrayList<Pizza> orderList = new ArrayList<>();
		
		orderList.add(new SweetPotatoPizza(12000, "피자헛"));
		orderList.add(new BulgogiPizza(10000, "일인피자"));
		orderList.add(new PineApplePizza(13000, "미스터피자"));
		orderList.add(new BulgogiPizza(20000, "도미노피자"));
		orderList.add(new SweetPotatoPizza(8000, "피자스쿨"));
		
		service.orderPizzas(orderList);
	}

}
