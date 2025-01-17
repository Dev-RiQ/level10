package Zombie;

import java.util.*;
//유닛은 전부 이동가능하며 pos는 현재 위치를 나타낸다 
//맵은 ~10까지 존재하며 한칸씩 이동 가능하다
//유닛들은 전부 attack 메서드를 구현한다 

public abstract class Unit {

	private String name;
	private int pos; // 현재위치
	private int hp; // 현재 hp
	private final int MAX_HP; // 최대 hp
	private int power; // 랜덤 공격 1부터 max 까지의 범위
	private int maxPower; // 공격 최대 범위
	private Random rd; // 각각 하위 유닛들이 이 랜덤 클래스 사용해서 공격 범위 지정
	private int damage;
	private boolean hasShield; // 하위 유닛 실드 보유 여부 ( 실드 파괴 여부)
	private boolean isCritical; // 직전 공격 크리티컬 여부 (회복량 저하용)

	protected boolean isCritical() {
		return isCritical;
	}

	protected void setCritical(boolean isCritical) {
		this.isCritical = isCritical;
	}

	protected String getName() {
		return name;
	}

	protected int getPos() {
		return pos;
	}

	protected int getHp() {
		return hp;
	}

	protected int getMAX_HP() {
		return MAX_HP;
	}

	protected int getPower() {
		return power;
	}

	protected Random getRd() {
		return rd;
	}

	protected boolean isHasShield() {
		return hasShield;
	}

	protected void setHasShield(boolean hasShield) {
		this.hasShield = hasShield;
	}

	protected int getDamage() {
		return damage;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setPos(int pos) {
		this.pos = pos;
	}

	protected void setHp(int hp) {
		this.hp = hp;
	}

	protected void setPower(int power) {
		this.power = power;
	}

	protected void setRd(Random rd) {
		this.rd = rd;
	}

	/** 상대의 직전 공격 데미지 저장 및 hp 감소 */
	protected void setDamage(int damage) {
		System.out.println(name + " - "+(hasShield? "실드 ":"HP ") + damage + "만큼 감소 !");
		this.damage = damage;
		if (hp < damage) damage = hp;
		hp -= damage;
	}

	public Unit(String name, int pos, int hp, int power) {
		this.name = name;
		this.pos = pos;
		this.hp = hp;
		MAX_HP = hp;
		maxPower = power;
		rd = new Random();
	}

	/** 유닛 이동 */
	protected void move() {
		pos++;
		System.out.println("앞으로 한 칸 이동합니다.");
		System.out.println("현재 위치 : " + pos);
	}

	/** 유닛 공격 모션 */
	protected int attack() {
		power = rd.nextInt(maxPower) + 1;
		System.out.println(name + " => " + power + "의 데미지로 공격 !");
		return power;
	}

	/** 유닛 치명타 공격 모션 */
	protected int criticalAttack() {
		System.out.println(name + "가 치명적인 일격을 사용하여 2배의 데미지를 입힘 !!");
		power = (rd.nextInt(maxPower) + 1) * 2;
		System.out.println(name + " => " + power + "의 데미지로 공격 !");
		isCritical = true;
		return power;
	}

	@Override
	public String toString() {
		return String.format("%s [ %d / %d ]", name, hp, MAX_HP);
	}

}
