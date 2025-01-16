package 추상_개념2;

public class MyCafe extends MyBrand {

	private static final String brandName = "역전 옆집 할머니 커피";

	public static String getSlogan() {
		return String.format(SLOGAN, brandName);
	}

	private static int myNum = 0;
	private boolean isTackOut;

	MyCafe(String name) {
		super(++myNum, name);
	}
	
	MyCafe(String name, boolean isTackOut) {
		super(++myNum, name);
		this.isTackOut = isTackOut;
	}

	@Override
	public void takeOrder() {
		System.out.printf(" %s %s 음료를 주문했습니다. \n%s", brandName, super.info(), isTackOut ? "" : " 매장에서 드시겠습니까? \n");
	}

	@Override
	public void printMyBrandInfo() {
		System.out.printf("%s %d호 (%s점)\n",brandName, NO, NAME);
	}

}
