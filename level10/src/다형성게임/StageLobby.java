package 다형성게임;
// 1. 전투 2.종료 (전투 -> Battle)
public class StageLobby extends Stage {

	@Override
	public boolean update() {
		System.out.println("=====[LOBBY]=====");
		int sel = Utils.getInstance().getValue("[1.전투] [2.종료] >> ", 1, 2);
		if (sel == 1)
			GameManager.getInstance().nextStage = StageName.BATTLE;
		else
			GameManager.getInstance().nextStage = StageName.NONE;
		return false;
	}

	@Override
	public void init() {
		
	}

}
