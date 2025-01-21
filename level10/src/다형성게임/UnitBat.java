package 다형성게임;

// 스킬 : 한명 침묵
public class UnitBat extends Unit {

	private static int num = 0;

	UnitBat() {
		super("Bat" + (++num));
	}

	@Override
	void skill() {
		System.out.println(name + "이 침묵 시전 !! ");
		isStun = true;
	}

}
