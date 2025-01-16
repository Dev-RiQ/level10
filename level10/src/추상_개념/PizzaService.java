package 추상_개념;

import java.util.ArrayList;

public class PizzaService {

	void orderPizzas(ArrayList<Pizza> orderList) {
		for(Pizza p : orderList) {
			p.makingPizza();
			System.out.println("------------------");
		}
	}
}
