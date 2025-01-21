package 다형성게임;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 플레이어 생성 (전사 hp : 1000 / power : 45 , 마법사 hp : 800 / power : 60 , 힐러 hp : 500 / power : 70)
// 몬스터 랜덤 소환 (HP : 100~200, power : 10~20
public class UnitManager {

	Random rd;
	List<Unit> mList;
	List<Player> pList;

	private UnitManager() {
		rd = new Random();
		mList = new ArrayList<>();
		pList = new ArrayList<>();
		pList.add(new PlayerWarrior(1000, 45));
		pList.add(new PlayerWizard(800, 60));
		pList.add(new PlayerHealer(500, 70));
	}

	private static UnitManager instance;

	public static UnitManager getInstance() {
		if (instance == null) instance = new UnitManager();
		return instance;
	}

	/** 랜덤 몬스터 생성 */
	public void setmList(int size) {
		String[] monster = { "UnitBat", "UnitOrc", "UnitWolf" };
		String path = UnitManager.class.getPackageName() + ".";
		for (int i = 0; i < size; i++) {
			try {
				addmList(path, monster);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/** 랜덤 몬스터 클래스 인스턴스 생성 후 리스트에 추가 */
	private void addmList(String path, String[] monster) throws Exception {
		Class<?> clazz = Class.forName(path + monster[rd.nextInt(monster.length)]);
		Object obj = clazz.getDeclaredConstructor().newInstance();
		Unit temp = (Unit) obj;
		int hp = 100 + rd.nextInt(101);
		int power = 10 + rd.nextInt(11);
		temp.init(hp, power);
		mList.add(temp);
	}

	/** player 모두 출력 */
	public void printPlayer() {
		if (pList.size() == 0) return;
		System.out.println("====== [ PLAYER ] ======");
		for (Player p : pList)
			System.out.println(p);
	}

	/** monster 모두 출력 */
	public void printMonster() {
		if (mList.size() == 0) return;
		System.out.println("====== [ MONSTER ] ======");
		for (Unit u : mList)
			System.out.println(u);
	}

	/** 남은 monster 수 */
	public int getmListSize() {
		return mList.size();
	}

	/** 남은 player 수 */
	public int getpListSize() {
		return pList.size();
	}

	/** 스턴 걸렸는지 체크 */
	private boolean hasStun(Unit unit) {
		if (unit.hasStun) {
			System.out.println(unit.name + "  스턴 중 공격 불가 !");
			unit.hasStun = false;
			return true;
		}
		return false;
	}

	/** player 공격력 기반 monster hp 감소 */
	public void setPlayerDamage(int idx) {
		if (pList.size() == 0) return;
		Unit monster = mList.get(idx);
		if(hasStun(monster)) return;
		int rd_index = rd.nextInt(pList.size());
		Player target = pList.get(rd_index);
		setDamage(pList, monster, target, rd_index);
		if (target.curhp == 0)
			pList.remove(rd_index);
	}

	/** monster 공격력 기반 player hp 감소 */
	public void setMonsterDamage(int idx) {
		if (mList.size() == 0) return;
		Player player = pList.get(idx);
		if(hasStun(player)) return;
		int rd_index = rd.nextInt(mList.size());
		Unit target = mList.get(rd_index);
		setDamage(mList, player, target, rd_index);
		if (target.curhp == 0)
			mList.remove(rd_index);
	}

	/** hp 깎고 데미지 및 처치 여부 출력 */
	private void setDamage(List<?> list, Unit unit, Unit target, int idx) {
		if (rd.nextInt(5) == 2)
			setSkillPower(list, unit, target);
		else {
			target.curhp -= unit.power;
			printDamage(unit.name, target.name, unit.power);
		}
		checkDead(target);
	}

	/** 데미지 적용 메세지 */
	private void printDamage(String name1, String name2, int damage) {
		System.out.println("[" + name1 + "] 가 " + "[" + name2 + "] 에게 [" + damage + "] 의 데미지를 입힙니다. ");
	}

	/** 스킬 효과 적용 메세지 */
	private void printDamage(String name1, String name2, String skill) {
		System.out.println("[" + name1 + "] 가 " + "[" + name2 + "] 에게 [" + skill + "] 효과를 적용힙니다. ");
	}

	/** 처치 여부 판단, 처치 시 출력 */
	private void checkDead(Unit target) {
		if (target.curhp <= 0) {
			System.out.println("[" + target.name + "] 를 처치했습니다.");
			target.curhp = 0;
		}
	}

	/** 스킬 사용 후 적용 로직 */
	private void setSkillPower(List<?> list, Unit unit, Unit target) {
		unit.skill();
		if(unit.isStun) setStun(unit, target);
		if(unit.isCritical) setCritical(unit, target);
		else if(unit.isArea) setArea(list, unit, target);
		else if(unit.isHeal) setHeal(unit);
		else printDamage(unit.name, target.name, unit.power);
	}

	/** 스턴 스킬 사용 시 적용 */
	private void setStun(Unit unit, Unit target) {
		target.hasStun = true;
		printDamage(unit.name, target.name, "스턴");
		unit.isStun = false;
	}

	/** 크리티컬 스킬 사용 시 적용 */
	private void setCritical(Unit unit, Unit target) {
		target.curhp -= unit.power * 2;
		printDamage(unit.name, target.name, unit.power * 2);
		unit.isCritical = false;
	}

	/** 광역 스킬 사용 시 적용 */
	@SuppressWarnings("unchecked")
	private void setArea(List<?> list, Unit unit, Unit target) {
		printDamage(unit.name, "모두", unit.power / 2);
		List<Unit> temp = (List<Unit>) list;
		for (int i = 0; i < list.size(); i++) {
			temp.get(i).curhp -= unit.power / 2;
			if (!target.equals(temp.get(i)))
				checkDead(temp.get(i));
		}
		unit.isStun = false;
	}

	/** 힐 스킬 사용 시 적용 */
	private void setHeal(Unit unit) {
		for (Player p : pList) {
			p.curhp += p.maxhp / 2;
			if (p.curhp > p.maxhp) p.curhp = p.maxhp;
		}
		unit.isHeal = false;
	}

}
