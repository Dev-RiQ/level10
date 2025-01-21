package 다형성게임;

public class PlayerHealer extends Player {

	PlayerHealer(int maxhp, int power) {
		super("힐러", maxhp, power);
	}

	@Override
	void skill() {
		System.out.println(name + "가 스킬 [어드벤스드 힐] 을 시전하여 모든 Player 최대 체력의 50% 회복 !! ");
		isHeal = true;
	}
}
