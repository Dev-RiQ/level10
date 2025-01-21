package 다형성게임;

// 플레이어, 몬스터 모두 출력
public class StageBattle extends Stage {

	/** player 공격력 기반 monster 데미지 입력 */
	private void player_attack(int idx) {
		UnitManager.getInstance().setMonsterDamage(idx);
	}

	/** monster 공격력 기반 player 데미지 입력 */
	private void unit_attack(int idx) {
		UnitManager.getInstance().setPlayerDamage(idx);
	}

	/** 모든 유닛 출력 */
	private void print_character() {
		UnitManager.getInstance().printPlayer();
		UnitManager.getInstance().printMonster();
	}

	@Override
	public void init() {
		UnitManager.getInstance().setmList(14);

	}

	@Override
	public boolean update() {
		System.out.println("=====[BATTLE]=====");
		while (true) {
			playerTurn();
			if (UnitManager.getInstance().getmListSize() <= 0) break;
			monsterTurn();
			if (UnitManager.getInstance().getpListSize() <= 0) break;
		}
		print_character();
		GameManager.getInstance().nextStage = StageName.NONE;
		return false;
	}

	/** player 모두 돌아가며 공격 */
	private void playerTurn() {
		print_character();
		for (int i = 0; i < UnitManager.getInstance().getpListSize(); i++)
			player_attack(i);
	}

	/** monster 모두 돌아가며 공격 */
	private void monsterTurn() {
		print_character();
		for (int i = 0; i < UnitManager.getInstance().getmListSize(); i++)
			unit_attack(i);
	}

}
