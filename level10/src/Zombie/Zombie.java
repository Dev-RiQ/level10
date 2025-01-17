package Zombie;

//좀비는 히어로 공격 가능하고 한턴이 지날때마다 공격한 대미지의 50%를 회복하는 능력을 가지고 있다 

public class Zombie extends Unit {

	public Zombie(String name, int pos, int hp, int power) {
		super(name, pos, hp, power);
	}

	/** 좀비 턴당 회복 로직 */
	public void selfHeal(boolean isCritical) {
		int hp = getHp();
		int heal = getDamage() / (isCritical ? 4 : 2);
		int healHp = (hp + heal) < getMAX_HP() ? (hp + heal) : getMAX_HP();
		setHp(healHp);
		System.out.println("턴이 변경되며 " + getName() + "가 직전 감소 HP의 50%를 회복합니다.");
		if (isCritical)
			System.out.println("크리티컬 히트를 입혀 회복률을 50% 감소시킵니다. (최종 25% 회복)");
		System.out.println(getName() + " => HP " + heal + "만큼 회복 !");
	}

}
