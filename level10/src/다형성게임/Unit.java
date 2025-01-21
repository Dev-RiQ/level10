package 다형성게임;

public abstract class Unit {

	int curhp;
	int maxhp;
	int power;
	String name;
	String state = "노말";
	
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
		return String.format("%s \t [ %d / %d ] [ power : %d ]", name,curhp,maxhp,power);
	}
	
}
