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
		if (instance == null)
			instance = new ZombieGame();
		return instance;
	}
	
	private void setHero() {
		hero = new Hero("히어로", 1, 200, 30, 2);
	}
	
	private void setUnit() {
		uList.add(new Zombie("좀비", 5, 100, 10));
		uList.add(new Boss("보스", 9, 300, 20, 100));
	}
	
	private int getValue(String msg, int start, int end, Scanner sc) {
		System.out.print(msg);
		while(true) {
			try {
				int sel = getInteger(msg, start, end, sc);
				return sel;
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}finally {
				sc.nextLine();
			}
		}
	}
	private int getInteger(String msg, int start, int end, Scanner sc) throws Exception {
		int sel = sc.nextInt();
		if(sel < 1 || sel > 2)
			throw new Exception();
		return sel;
	}
	
	private void move() {
		hero.move();
	}
	
	private boolean hasUnit() {
		for(Unit u : uList)
			if(u.getPos() == hero.getPos()) {
				if(u.getName().equals("좀비"))
					System.out.println("좀비를 만났다 !");
				else
					System.out.println("보스를 만났다 !");
				return true;
			}
		System.out.println("이곳에는 아무것도 없습니다..");
		return false;
	}
	
	private void fight(Scanner sc) {
		Unit unit = uList.get(0);
		while(true) {
			System.out.println(hero + " vs " + unit);
			int sel = getValue("공격하기(1), 포션 마시기(2)- 잔여 "+hero.getPotion()+"개 >> ", 1, 2, sc);
			System.out.println("==================");
			if(sel == 1) {
				unit.setDamage(hero.attack());
			}else
				hero.drinkPotion();
			System.out.println(hero + " vs " + unit);
			if(hasDead(unit))
				break;
			System.out.println("==================");
			hero.setDamage(unit.attack());
			System.out.println(hero + " vs " + unit);
			if(hasDead())
				break;
			System.out.println("==================");
			if(unit.getName().equals("좀비")) {
				((Zombie) unit).selfHeal();
			}
		}
	}
	
	private boolean hasDead() {
		if(hero.getHp() > 0)
			return false;
		System.out.println("임무를 완수하지 못한채 눈을 감아버린 히어로..");
		return true;
	}
	
	private boolean hasDead(Unit unit) {
		if(unit.getHp() <= 0 && uList.size() != 1) {
			System.out.println("좀비 소탕 완료 !!");
			uList.remove(0);
			return true;
		}else if(unit.getHp() <= 0) {
			System.out.println("보스 소탕 완료 !!");
			uList.remove(0);
			return true;
		}
		return false;
	}
	
	private void gameEnd(boolean isEnd) {
		if(hero.getPos() == MAP_SIZE || isEnd)
			System.out.println("게임 클리어!");
		else
			System.out.println("게임 오버..");
	}
	
	private boolean isEnd(boolean isOver) {
		if(!isOver)
			return false;
		System.out.println("게임을 종료합니다.");
		return true;
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		setHero();
		setUnit();
		boolean isEnd = false;
		while(!isEnd) {
			System.out.println("현재 위치 : "+hero.getPos());
			int sel = getValue("앞으로 이동하기(1), 종료하기(2) >> ", 1, 2, sc);
			if(sel == 1) {
				move();
				if(hasUnit())
					fight(sc);
			}else
				isEnd = isEnd(true);
			System.out.println("=================================");
			if(uList.size() == 0 || hero.getHp() <= 0)
				break;
		}
		gameEnd(isEnd);
	}

}
