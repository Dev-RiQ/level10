package 다형성실습;

import java.util.ArrayList;
import java.util.Random;

interface Repairable2 {
}

interface Healable2 {
}

interface Damageable2 {
	void damage(int damage);
}

class Unit2 implements Damageable2 {
	protected static int num = 1;
	protected String name;
	protected final int MAX_HP;
	protected int hp;

	protected Unit2(int hp) {
		MAX_HP = hp;
		this.hp = MAX_HP;
	}

	@Override
	public void damage(int damage) {
		hp -= damage;
	}
}

class GroundUnit2 extends Unit2 {
	public GroundUnit2(int hp) {
		super(hp);
	}

}

class AirUnit2 extends Unit2 {
	public AirUnit2(int hp) {
		super(hp);
	}

}

class Tank2 extends GroundUnit2 implements Repairable2 {

	private static final int HP = 250;

	public Tank2() {
		super(HP);
	}

	@Override
	public String toString() {
		return String.format("%s (%d/ %d )", name, hp, MAX_HP);
	}

}

class Soldier2 extends GroundUnit2 implements Healable2 {

	private static final int HP = 120;

	public Soldier2() {
		super(HP);
	}

	@Override
	public String toString() {
		return String.format("%s (%d/ %d )", name, hp, MAX_HP);
	}

}

class Aircraft2 extends AirUnit2 implements Repairable2 {

	private static final int HP = 150;

	public Aircraft2() {
		super(HP);
	}

	@Override
	public String toString() {
		return String.format("%s (%d/ %d )", name, hp, MAX_HP);
	}

}

class DropShip2 extends AirUnit2 implements Repairable2 {

	private static final int HP = 200;

	public DropShip2() {
		super(HP);
	}

	@Override
	public String toString() {
		return String.format("%s (%d/ %d )", name, hp, MAX_HP);
	}

}

class SCV2 extends GroundUnit2 implements Repairable2 {

	private static final int HP = 130;

	public SCV2() {
		super(HP);
	}

	public void repairUnit(Repairable2 repairable, int max) {
		Unit2 unit = (Unit2) repairable; // 다형성

		for (int i = 0; i < max; i++) {
			unit.hp++;
			if (unit.hp == unit.MAX_HP)
				break;
		}
		System.out.println(" [hp +" + max + "] " + unit + "수리 완료!!");

	}

	@Override
	public String toString() {
		return String.format("%s (%d/ %d )", name, hp, MAX_HP);
	}
}

class UnitDAO2 {

	private ArrayList<Unit2> uList;

	public UnitDAO2() {
		uList = new ArrayList<>();
		setuList();
	}

	public Unit2 getUnit(int idx) {
		return uList.get(idx);
	}

	public int getuListSize() {
		return uList.size();
	}

	public void removeuList(int idx) {
		uList.remove(idx);
	}

	private void setuList() {
		Random rd = new Random();
		for (int i = 0; i < 10; i++) {
			addNewList(rd);
			Unit2 unit = uList.get(i);
			unit.name = unit.getClass().getSimpleName() + (Unit2.num++);
		}
	}
	
	private void addNewList(Random rd) {
		switch (rd.nextInt(5)) {
		case 0: uList.add(new Tank2()); break;
		case 1: uList.add(new Soldier2()); break;
		case 2: uList.add(new Aircraft2()); break;
		case 3: uList.add(new DropShip2()); break;
		case 4: uList.add(new SCV2()); break;
		}
	}
}

class Starcraft2 {
	private UnitDAO2 udao;

	private Starcraft2() {
		udao = new UnitDAO2();
	}

	private static Starcraft2 instance;

	public static Starcraft2 getInstance() {
		if (instance == null)
			instance = new Starcraft2();
		return instance;
	}

	private int[] getIdx(Random rd) {
		int[] idxs = new int[2];
		idxs[0] = rd.nextInt(udao.getuListSize());
		while (true) {
			idxs[1] = rd.nextInt(udao.getuListSize());
			if (idxs[0] != idxs[1])
				return idxs;
		}
	}

	private Unit2[] getUnit(int[] idxs) {
		Unit2[] units = new Unit2[2];
		units[0] = udao.getUnit(idxs[0]);
		units[1] = udao.getUnit(idxs[1]);
		return units;
	}

	private void damaged(Random rd, Unit2[] units) {
		int damage = rd.nextInt(20) + 10;
		System.out.println(units[0] + " ==> " + units[1] + " " + damage + " 데미지로 공격");
		units[1].damage(damage);
	}

	private void printResult(Unit2[] units, int idx) {
		System.out.println("                            ▼ ▼");
		System.out.println("                        " + units[1] + (units[1].hp <= 0 ? " (사망)" : ""));
		if (units[1].hp <= 0)
			udao.removeuList(idx);
		System.out.println("남은 유닛 수 : " + udao.getuListSize());
		System.out.println("------------------");
	}

	private void war() {
		Random rd = new Random();
		while (udao.getuListSize() > 1) {
			int[] idxs = getIdx(rd);
			Unit2[] units = getUnit(idxs);
			damaged(rd, units);
			printResult(units, idxs[1]);
		}
		System.out.println("최종 생존 : " + udao.getUnit(0));
	}

	public void run() {
		war();
	}

}

public class _02스타크래프트2 {
	public static void main(String[] args) {

		Starcraft2.getInstance().run();
	}
}

