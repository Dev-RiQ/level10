package 다형성게임;

public abstract class Stage {
	enum StageName { TITLE, LOBBY, BATTLE, NONE }

	/** 스테이지 진행 */
	abstract boolean update();

	/** 스테이지 관련 정보 셋팅 */
	abstract void init();
}
