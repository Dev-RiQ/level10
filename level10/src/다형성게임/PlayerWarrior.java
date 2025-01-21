package 다형성게임;

public class PlayerWarrior extends Player {

	PlayerWarrior(int maxhp, int power) {
		super("전사", maxhp, power);
	}

	@Override
	void skill() {
		System.out.println(name + "가 스킬 [디바인 차지] 를 시전하여 크리티컬 + 기절 공격 !! ");
		isCritical = true;
		isStun = true;
	}

}
