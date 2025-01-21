package 다형성게임;

public class PlayerWizard extends Player {

	PlayerWizard(int maxhp, int power) {
		super("마법사", maxhp, power);
	}

	@Override
	void skill() {
		System.out.println(name + "이 스킬 [블리자드] 를 시전하여 공격력의 절반으로 광역 공격 !! ");
		isArea = true;
	}
}
