package 다형성게임;

//스킬 : 광역기 (공격력 절반)
public class UnitWolf extends Unit {

	private static int num = 0;

	UnitWolf() {
		super("Wolf" + (++num));
	}

	@Override
	void skill() {
		System.out.println(name + "이 공격력의 절반으로 광역 공격 시전 !! ");
		isArea = true;
	}

}
