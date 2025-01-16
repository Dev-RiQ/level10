package 추상_개념2;

public class MyBakery extends MyBrand {

	private static final String brandName = "역전 증조 할머니 빵집";

	public static String getSlogan() {
		return String.format(SLOGAN, brandName);
	}

	private static int myNum = 0;
	private boolean isHandmade;

	MyBakery(String name) {
		super(++myNum, name);
	}
	
	MyBakery(String name, boolean isHandMade) {
		super(++myNum, name);
		this.isHandmade = isHandMade;
	}

	@Override
	public void takeOrder() {
		System.out.printf(" %s %s 빵을 주문했습니다. \n", brandName, super.info() + (isHandmade ? " 수제" : ""));
	}

	@Override
	public void printMyBrandInfo() {
		System.out.printf("%s %d호 (%s점)\n",brandName, NO, NAME);
	}

}
