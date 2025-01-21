package 다형성게임;

// 스킬 : 한명 2배 데미지 + 기절
public class UnitOrc extends Unit {

	private static int num = 0;

	UnitOrc() {
		super("Orc" + (++num));
	}

	@Override
	void skill() {
		System.out.println(name + "이 크리티컬 + 기절 시전 !! ");
		isCritical = true;
		isStun = true;
	}

}
