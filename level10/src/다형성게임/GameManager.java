package 다형성게임;

import java.util.HashMap;
import java.util.Map;

public class GameManager {

	Stage.StageName curStage;
	Stage.StageName nextStage;
	Map<Stage.StageName, Stage> stageList;

	private static GameManager instance;

	public static GameManager getInstance() {
		if (instance == null)
			instance = new GameManager();
		return instance;
	}

	private GameManager() {
		stageList = new HashMap<>();
		stageList.put(Stage.StageName.TITLE, new StageTitle());
		stageList.put(Stage.StageName.LOBBY, new StageLobby());
		stageList.put(Stage.StageName.BATTLE, new StageBattle());
		curStage = Stage.StageName.NONE;
		nextStage = Stage.StageName.TITLE;
	}

	/** 스테이지 로드 */
	private Stage getStage(Stage.StageName key) {
		return stageList.get(key);
	}

	/** 스테이지 이동 */
	private boolean changeStage() {
		System.out.println("curStage : " + (curStage == Stage.StageName.NONE ? "" : curStage));
		System.out.println("nextStage : " + (nextStage == Stage.StageName.NONE ? "" : nextStage));

		curStage = nextStage;
		Stage stage = getStage(curStage);
		stage.init();

		boolean run = true;
		while (true) {
			run = stage.update();
			if (run == false) break;
		}

		if (nextStage == Stage.StageName.NONE)
			return false;
		else
			return true;
	}

	/** 게임 종료시 승리 여부 출력 */

	void run() {
		boolean run = true;
		while (true) {
			run = changeStage();
			if (run == false)
				break;
		}
		System.out.println("게임 종료");
	}

}
