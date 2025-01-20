package 열거타입;

public class PizzaStore {

	PizzaMenu[] menu = PizzaMenu.values();
	
	void printAllMenu() {
		for(PizzaMenu pizza : menu)
			System.out.println(pizza);
	}
	
	void takeOrder(String name) {
		PizzaMenu menu = PizzaMenu.getMenu(name);
		if(menu == null)
			System.out.println("해당 피자는 존재하지 않습니다.");
		else
			System.out.println(name + "는 " + menu.getPrice() + "원입니다~");
	}
}
