package 다형성게임;
//스킬 : 한명 2배 데미지 + 기절
public class UnitOrc extends Unit {

	private static int num = 0;
	
	UnitOrc() {
		super("Orc"+(++num));
	}

	@Override
	void skill() {
		System.out.println("플레이어 한 명 데미지 2배 + 기절 !! ");		
	}

}
