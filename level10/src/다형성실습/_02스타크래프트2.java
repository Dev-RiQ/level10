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
	private static int num = 1;
	private String name;
	private final int MAX_HP;
	private int hp;

	protected Unit2(int hp) {
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
	
	protected static int getNum() {
		return num;
	}

	protected String getName() {
		return name;
	}

	protected void setHp(int hp) {
		this.hp = hp;
	}

	protected int getMAX_HP() {
		return MAX_HP;
	}

	protected int getHp() {
		return hp;
	}

	protected static void setNum(int num) {
		Unit2.num = num;
	}

	protected void setName(String name) {
		this.name = name;
	}


	@Override
	public void damage(int damage) {
		hp -= damage;
	}

	@Override
	public String toString() {
		return String.format("%s [ %d / %d ]", name, hp, MAX_HP);
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


}

class Soldier2 extends GroundUnit2 implements Healable2 {

	private static final int HP = 120;

	public Soldier2() {
		super(HP);
	}

}

class Aircraft2 extends AirUnit2 implements Repairable2 {

	private static final int HP = 150;

	public Aircraft2() {
		super(HP);
	}

}

class DropShip2 extends AirUnit2 implements Repairable2 {

	private static final int HP = 200;

	public DropShip2() {
		super(HP);
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
			unit.setHp(unit.getHp() + 1);
			if (unit.getHp() == unit.getMAX_HP())
				break;
		}
		System.out.println(" [hp +" + max + "] " + unit + "수리 완료!!");

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
		String[] unitNames = {"Tank2","Soldier2","Aircraft2","DropShip2","SCV2"};
		for (int i = 0; i < 10; i++) {
			int idx = rd.nextInt(5);
			String unitName = unitNames[idx];
			setNewInstance(unitName);
			uList.get(i).setName(unitName.replace("2", " ") + Unit2.getNum());
			Unit2.setNum(Unit2.getNum()+1);
		}
	}
	
	private void setNewInstance(String unitName) {
		try {
			addUnit(unitName);
		} catch (Exception e) {
		}
	}
	
	private void addUnit(String unit) throws Exception{
		String packagetName = _02스타크래프트2.class.getPackageName() + ".";
		uList.add((Unit2) Class.forName(packagetName + unit).getDeclaredConstructor().newInstance());
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
		System.out.println("                        " + units[1] + (units[1].getHp() <= 0 ? " (사망)" : ""));
		if (units[1].getHp() <= 0)
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

