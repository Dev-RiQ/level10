package Zombie;

import java.util.*;
//유닛은 전부 이동가능하며 pos는 현재 위치를 나타낸다 
//맵은 ~10까지 존재하며 한칸씩 이동 가능하다
//유닛들은 전부 attack 메서드를 구현한다 

public abstract class Unit {

	private String name;
	private int pos; // 현재위치
	private int hp; // 현재 hp
	private final int MAX_HP;
	private int power; // 랜덤 공격 1부터 max 까지의 범위
	private Random rd; // 각각 하위 유닛들이 이 랜덤 클래스 사용해서 공격 범위 지정
	private int damage;
	
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
	
	protected void setDamage(int damage) {
		this.damage = damage;
		System.out.println(name+" - " + damage +"만큼 피격 !");
		if(hp < damage) damage = hp;
		hp -= damage;
	}

	public Unit(String name, int pos, int hp, int power) {
		this.name = name;
		this.pos = pos;
		this.hp = hp;
		MAX_HP = hp;
		this.power = power;
		rd = new Random();
	}
	
	protected void move() {
		pos++;
		System.out.println("앞으로 한 칸 이동합니다.");
		System.out.println("현재 위치 : "+pos);
	}
	
	protected int attack() {
		System.out.println("공격합니다.");
		return power;
	}

	@Override
	public String toString() {
		return String.format("%s [ %d / %d ]", name, hp, MAX_HP);
	}
	
	
}
