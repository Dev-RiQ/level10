package 추상_개념2;

public class MyChicken extends MyBrand {

	private static final String brandName = "역전 고조 할아버지 치킨집";

	public static String getSlogan() {
		return String.format(SLOGAN, brandName);
	}

	private static int myNum = 0;

	MyChicken(String name) {
		super(++myNum, name);
	}

	@Override
	public void takeOrder() {
		System.out.printf(" %s %s 치킨을 주문했습니다. \n", brandName, super.info());
	}

	@Override
	public void printMyBrandInfo() {
		System.out.printf("%s %d호 (%s점)\n",brandName, NO, NAME);
	}

}
