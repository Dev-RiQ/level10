package 인터페이스;

interface Repairable {
}

interface Healable {
}

class Unit {
	final int MAX_HP;
	int hp;

	public Unit(int hp) {
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
}

class GroundUnit extends Unit {
	public GroundUnit(int hp) {
		super(hp);
	}

}

class AirUnit extends Unit {
	public AirUnit(int hp) {
		super(hp);
	}

}

class Tank extends GroundUnit implements Repairable {
	public Tank() {
		super(250);
	}

	@Override
	public String toString() {
		return String.format("Tank (%d/ %d )", hp, MAX_HP);
	}

}

class Soldier extends GroundUnit {
	public Soldier() {
		super(120);
	}

	@Override
	public String toString() {
		return String.format("Soldier (%d/ %d )", hp, MAX_HP);
	}

}

class Aircraft extends AirUnit implements Repairable {
	public Aircraft() {
		super(150);
	}

	@Override
	public String toString() {
		return String.format("Aircraft (%d/ %d )", hp, MAX_HP);
	}

}

class DropShip extends AirUnit implements Repairable {
	public DropShip() {
		super(200);
	}

	@Override
	public String toString() {
		return String.format("DropShip (%d/ %d )", hp, MAX_HP);
	}

}

class SCV extends GroundUnit implements Repairable {
	public SCV() {
		super(130);
	}

	void repairUnit(Repairable repairable) {
		Unit unit = (Unit) repairable; // 다형성

		while (unit.hp != unit.MAX_HP) {
			unit.hp++;
		}
		System.out.println(unit + " 수리 완료!!");

	}

	@Override
	public String toString() {
		return String.format("SCV (%d/ %d )", hp, MAX_HP);
	}
}

public class _05마크인터페이스 {
	public static void main(String[] args) {

		Tank tank = new Tank();
		DropShip dropShip = new DropShip();
		Soldier soldier = new Soldier();
		SCV scv = new SCV();

		System.out.println(tank);
		tank.hp -= 30;
		System.out.println(tank);

		dropShip.hp -= 30;
		soldier.hp -= 40;

		scv.repairUnit(scv);

	}
}
