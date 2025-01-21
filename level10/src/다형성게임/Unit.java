package 다형성게임;

public abstract class Unit {

	protected int curhp;
	protected int maxhp;
	protected int power;
	protected String name;
	protected String state = "노말";
	protected boolean hasStun;
	protected boolean isStun;
	protected boolean isArea;
	protected boolean isCritical;
	protected boolean isHeal;

	Unit(String name) {
		this.name = name;
	}

	Unit(String name, int maxhp, int power) {
		this.curhp = maxhp;
		this.maxhp = maxhp;
		this.power = power;
		this.name = name;
	}

	abstract void skill();

	void attack() {

	}

	public void init(int hp, int power) {
		this.curhp = hp;
		this.maxhp = hp;
		this.power = power;
	}

	@Override
	public String toString() {
		return String.format("%s \t [ %d / %d ] [ power : %d ]", name, curhp, maxhp, power);
	}

}
