package 다형성실습;
import java.util.ArrayList;
import java.util.Random;
interface Repairable {
}
interface Healable {
}
interface Damageable {
	void damage(int damage);
}
class Unit implements Damageable {
	final int MAX_HP;
	int hp;
	public Unit(int hp) {
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
	@Override
	public void damage(int damage) {
		hp -= damage;
		System.out.print(" [hp -" + damage + "] ");
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
class Soldier extends GroundUnit implements Healable {
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
	void repairUnit(Repairable repairable, int max) {
		Unit unit = (Unit) repairable; // 다형성
		for (int i = 0; i < max; i++) {
			unit.hp++;
			if (unit.hp == unit.MAX_HP)
				break;
		}
		System.out.println(" [hp +" + max + "] "+unit +"수리 완료!!");
	}
	@Override
	public String toString() {
		return String.format("SCV (%d/ %d )", hp, MAX_HP);
	}
}
public class _02스타크래프트 {
	public static void main(String[] args) {
		Random rd = new Random();
		ArrayList<Unit> uList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			switch (rd.nextInt(5)) {
			case 0: uList.add(new Tank()); break;
			case 1: uList.add(new Soldier()); break;
			case 2: uList.add(new Aircraft()); break;
			case 3: uList.add(new DropShip()); break;
			case 4: uList.add(new SCV()); break;
			}
		}
		
		while (uList.size() > 1) {
			boolean hasSCV = false;
			int idx = -1;
			for (int i = 0; i < uList.size(); i++) {
				uList.get(i).damage(rd.nextInt(20) + 10);
				Unit unit = uList.get(i);
				System.out.println(unit + (unit.hp <= 0 ? " (사망)" : ""));
				if (unit.hp <= 0) {
					uList.remove(i--);
					continue;
				}
				if (unit.getClass().getSimpleName().equals("SCV")) {
					hasSCV = true;
					idx = i;
				}
			}
			if (hasSCV) {
				SCV scv = (SCV) uList.get(idx);
				for (int i = 0; i < uList.size(); i++) {
					try {
						Unit unit = (Unit) uList.get(i);
						scv.repairUnit((Repairable) unit, rd.nextInt(11) + 10);
					} catch (Exception e) {
					}
				}
			}
			System.out.println("============");
		}
		if(uList.size() == 0)
			System.out.println("전멸...");
		else
			System.out.println("최종 생존 : " + uList.get(0));
	}
}