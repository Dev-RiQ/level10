package Zombie;

import java.util.*;

//현재 위치
// 앞으로 이동 / 종료
// 좀비있으면 공격모드 (공격/포션) 둘중 누가죽나
// 보스 마찬가지
// 10칸 다가면 히어로 승리

public class ZombieGame {

	private final int MAP_SIZE;
	private ArrayList<Unit> uList;
	private Hero hero;

	private ZombieGame() {
		MAP_SIZE = 10;
		uList = new ArrayList<>();
	}

	private static ZombieGame instance;

	public static ZombieGame getInstance() {
		if (instance == null) instance = new ZombieGame();
		return instance;
	}

	/** 캐릭터 선택 */
	private void setHero() {
		// TODO : 캐릭터 다양화 -> 선택창 추가 예정
		hero = new Hero("히어로", 1, 200, 30, 2);
	}

	/** 몬스터 설정 */
	private void setUnit() {
		// TODO : 몬스터 다양화 -> 난이도 추가 예정
		uList.add(new Zombie("좀비", 5, 100, 10));
		uList.add(new Boss("보스", 9, 300, 20, 100));
	}

	/** 입력 값 오류 처리 후 리턴 */
	private int getValue(String msg, int start, int end, Scanner sc) {
		System.out.print(msg);
		while (true) {
			try {
				return getInteger(msg, start, end, sc);
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			} finally {
				sc.nextLine();
			}
		}
	}

	/** 인트값 입력 받아오기 */
	private int getInteger(String msg, int start, int end, Scanner sc) throws Exception {
		int sel = sc.nextInt();
		if (sel < 1 || sel > 2)
			throw new Exception();
		return sel;
	}

	/** 이동 */
	private void move() {
		hero.move();
	}

	/** 해당 칸에 몬스터가 있는지 여부 */
	private boolean hasUnit() {
		for (Unit u : uList)
			if (u.getPos() == hero.getPos()) {
				System.out.println(u.getName() + "를 만났다 !");
				return true;
			}
		System.out.println("이곳에는 아무것도 없습니다..");
		return false;
	}

	/** 전투(체력) 현황 표시 */
	private void printUnits() {
		System.out.println(hero + " vs " + uList.get(0));
		System.out.println("==================");
	}

	/** 공격 / 회복 선택 */
	private boolean validAction(int sel) {
		System.out.println("[ Hero Turn !!! ]");
		if (sel == 1)
			uList.get(0).setDamage(hero.attack());
		else {
			if (hero.getPotion() == 0) {
				System.out.println("사용할 수 있는 포션이 없습니다.");
				return false;
			}
			hero.drinkPotion();
		}
		printUnits();
		return true;
	}

	/** 몬스터가 유저 공격 */
	private void unitAttack() {
		System.out.println("[ " + uList.get(0).getName() + " Turn !!! ]");
		hero.setDamage(uList.get(0).attack());
		printUnits();
	}

	/** 좀비 턴당 회복 */
	private void zombieHeal() {
		if (uList.get(0).getName().equals("보스") && !(((Boss) uList.get(0)).getShield() == 0))
			return;
		((Zombie) uList.get(0)).selfHeal(hero.isCritical());
		printUnits();
	}

	/** 결투 로직 */
	private void fight(Scanner sc) {
		while (true) {
			int sel = getValue("공격하기(1), 포션 마시기(2)- 잔여 " + hero.getPotion() + "개 >> ", 1, 2, sc);
			if (!validAction(sel)) continue;
			if (monsterDead()) break;
			unitAttack();
			if (isHeroDead()) break;
			if (sel == 1) zombieHeal();
			hero.setCritical(false);
		}
	}
	
	/** 히어로 사망여부 */
	private boolean isHeroDead() {
		return hero.getHp() > 0? false : true;
	}
	
	/** 몬스터 처치 여부 */
	private boolean monsterDead() {
		if(uList.get(0).getHp() > 0) return false;
		System.out.println(uList.get(0).getName() + " 소탕 완료 !!");
		uList.remove(0);
		return true;
	}
	
	/** 게임 클리어 여부 */
	private void gameEnd(boolean isEnd) {
		if (!isHeroDead() || hero.getPos() == MAP_SIZE || isEnd)
			System.out.println("게임 클리어!");
		else
			System.out.println("[Bad Ending] 임무를 완수하지 못한채 눈을 감아버린 히어로.. \n 게임 오버..");
	}

	/** 게임 종료 여부 */
	private boolean isEnd(boolean isOver) {
		if(!isOver) return false;
		System.out.println("게임을 종료합니다.");
		return true;
	}

	/** 좀비 사냥 게임 실행 */
	public void run() {
		Scanner sc = new Scanner(System.in);
		setHero();
		setUnit();
		boolean isEnd = false;
		while (!isEnd) {
			System.out.println("현재 위치 : " + hero.getPos());
			int sel = getValue("앞으로 이동하기(1), 종료하기(2) >> ", 1, 2, sc);
			if (sel == 1) {
				move();
				if (hasUnit()) fight(sc);
			} else
				isEnd = isEnd(true);
			if (uList.size() == 0 || hero.getHp() <= 0) break;
			System.out.println("=================================");
		}
		gameEnd(isEnd);
	}

}
