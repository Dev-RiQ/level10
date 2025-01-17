package Zombie;

import java.util.*;
//Boss 클래스는 Zombie 클래스를 상속받는다.
//Boss 클래스는 보호막 shield 멤버변수를 가진다.
//공격 메소드 void attack( Unit enemy ) 
//일반공격 : 1~공격력(max) 사이의 랜덤 값을 공격력으로 사용하여 enemy의 체력 감소시킴 (출력 예 : “보스가 15 의 공격력으로 일반 공격 : 현재 Hero의 hp는 25”)
//필살기 : 25%의 확률로 1~max 사이의 공격력의 2배 만큼으로 상대를 공격하는 기능 (출력 예 : “보스가 30 의 공격력으로 필살기 공격 : 현재 Hero의 hp는 25”)
//Boss 클래스는 생성자를 가짐(현재위치, 체력,공격력, 보호막)

public class Boss extends Zombie {

	private final int MAX_SHIELD;
	private int shield;

	public Boss(String name, int pos, int hp, int power, int shield) {
		super(name, pos, hp, power);
		this.shield = shield;
		MAX_SHIELD = shield;
		setHasShield(true);
	}

	protected int getShield() {
		return shield;
	}

	@Override
	protected int attack() {
		Random rd = new Random();
		int num = rd.nextInt(4);
		if (num == 0)
			return super.criticalAttack();
		return super.attack();
	}
	
	/** 실드가 데미지보다 많을 때 */
	private void enoughShield(int damage) {
		super.setDamage(shield);
		setHp(getMAX_HP());
		setHasShield(false);
		super.setDamage(damage - shield);
		shield = 0;
	}
	
	/** 실드보다 데미지가 많을 때 */
	private void notEnoughShield(int damage) {
		super.setDamage(damage);
		setHp(getMAX_HP());
		shield -= damage;
	}

	@Override
	protected void setDamage(int damage) {
		if (shield > 0 && damage > shield)
			enoughShield(damage);
		else if (shield > 0)
			notEnoughShield(damage);
		else
			super.setDamage(damage);
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" (쉴드 [ %d / %d ])", shield, MAX_SHIELD);
	}

}
