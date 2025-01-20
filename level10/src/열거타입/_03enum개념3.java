package 열거타입;

import java.util.ArrayList;

public class _03enum개념3 {

	public static void main(String[] args) {

		ArrayList<PizzaMenu> list = new ArrayList<>();
		list.add(PizzaMenu.PP);
		list.add(PizzaMenu.CP);
		list.add(PizzaMenu.SP);
		list.add(PizzaMenu.MP);
		list.add(PizzaMenu.HP);
		list.add(PizzaMenu.BP);
		
		for(PizzaMenu pizza : list)
			System.out.println(pizza.getDesc());
		
		for(PizzaMenu pizza : list)
			System.out.println(pizza.name());
		System.out.println("===========");
		for(PizzaMenu pizza : list)
			System.out.println(pizza.ordinal());
		System.out.println("===========");
		PizzaStore pizzaStore = new PizzaStore();
		pizzaStore.printAllMenu();
		
		pizzaStore.takeOrder("마라피자");
		pizzaStore.takeOrder("고구마피자");
	}

}
