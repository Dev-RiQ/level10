package 추상_개념2;

public abstract class MyBrand {

	protected static final String SLOGAN = " 우리 %s 매장은 가성비 좋다. ";
	protected final int NO;
	protected final String NAME;

	MyBrand(int no, String name) {
		NO = no;
		NAME = name;
	}

	public String info() {
		return String.format("%d호 %s점", NO, NAME);
	}
	
	public abstract void takeOrder();
	
	public abstract void printMyBrandInfo();
}
