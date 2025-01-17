package Zombie;

import java.util.Random;

//보스인지 아닌지 구분해서 공격 

//히어로는 체력 포션으로 100 체력 회복할 수 있고 체력 포션이 없으면 체력 회복이 안된다 
//외부의 적은 보스인지 아닌지 구별해서 공격 해야한다 
//보스이면 보호막을 가지고 있다 먼저 보호막을 다 뚫어야지만 직접 보스를 공격할 수 있다. 
//일반 적은 보호막 가지고 있지 않음 

public class Hero extends Unit {

	private int potion;

	protected int getPotion() {
		return potion;
	}

	public Hero(String name, int pos, int hp, int power, int potion) {
		super(name, pos, hp, power);
		this.potion = potion;
	}

	/** 포션 사용 */
	public void drinkPotion() {
		potion--;
		System.out.println("포션을 사용하여 100의 HP를 회복합니다.");
		int healHp = (getMAX_HP() - getHp()) < 100 ? getMAX_HP() : (getHp() + 100);
		setHp(healHp);
	}

	@Override
	protected int attack() {
		// TODO: 나중에 보스 공격력, 방어율무시 등 추가 예정
		Random rd = new Random();
		int num = rd.nextInt(4);
		if (num == 0)
			return super.criticalAttack();
		return super.attack();
	}

}
