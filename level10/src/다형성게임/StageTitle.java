package 다형성게임;

// 시작 -> LOBBY
public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("==== TEXT RPG ====");
		String start = Utils.getInstance().getValue("[시작] 을 입력하세요 >> ");
		if (start.equals("시작"))
			GameManager.getInstance().nextStage = StageName.LOBBY;
		else
			Utils.getInstance().showErrorMsg("시작을 정확히 입력하세요.");
		return false;
	}

	@Override
	public void init() {

	}

}
