package Zombie;

//좀비는 히어로 공격 가능하고 한턴이 지날때마다 공격한 대미지의 50%를 회복하는 능력을 가지고 있다 

public class Zombie extends Unit {

	public Zombie(String name, int pos, int hp, int power) {
		super(name, pos, hp, power);
	}

	public void selfHeal() {
		int hp = getHp();
		int heal = getDamage() / 2;
		int healHp = (hp + heal) < getMAX_HP() ? (hp + heal) : getMAX_HP();
		setHp(healHp);
		System.out.println("턴이 변경되며 좀비가 최근 피격 데미지의 50%를 회복합니다.");
	}

	@Override
	protected int attack() {
		System.out.println(getName() +" - "+ getPower() + "의 데미지로 공격 !");
		return getPower();
	}

}
