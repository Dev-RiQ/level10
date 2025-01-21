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
		pList.add(new Player("전사", 1000, 45));
		pList.add(new Player("마법사", 800, 60));
		pList.add(new Player("힐러", 500, 70));
	}

	private static UnitManager instance;

	public static UnitManager getInstance() {
		if (instance == null)
			instance = new UnitManager();
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

	public int getmListSize() {
		return mList.size();
	}

	public int getpListSize() {
		return pList.size();
	}

	/** player 공격력 기반 monster hp 감소 */
	public void setPlayerDamage(int idx) {
		if (pList.size() == 0) return;
		int rd_index = rd.nextInt(pList.size());
		Unit monster = mList.get(idx);
		Player target = pList.get(rd_index);
		printDamage(monster, target, rd_index);
		if (target.curhp == 0)
			pList.remove(rd_index);
	}

	/** monster 공격력 기반 player hp 감소 */
	public void setMonsterDamage(int idx) {
		if (mList.size() == 0) return;
		int rd_index = rd.nextInt(mList.size());
		Unit target = mList.get(rd_index);
		Player player = pList.get(idx);
		printDamage(player, target, rd_index);
		if (target.curhp == 0)
			mList.remove(rd_index);
	}

	/** hp 깎고 데미지 및 처치 여부 출력 */
	private void printDamage(Unit unit, Unit target, int idx) {
		target.curhp -= unit.power;
		System.out.println("[" + unit.name + "] 가 " + "[" + target.name + "] 에게 " + unit.power + "의 데미지를 입힙니다. ");
		if (target.curhp <= 0) {
			System.out.println("[" + target.name + "] 를 처치했습니다.");
			target.curhp = 0;
		}
	}
}
