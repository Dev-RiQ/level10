package 쓰레드;

import java.util.Random;

class CostomerRun implements Runnable{
	
	String name;
	ATM atm;
	int needMoney;
	
	CostomerRun(String name, ATM atm, int needMoney) {
		this.name = name;
		this.atm = atm;
		this.needMoney = needMoney;
	}

	@Override
	public void run() {
		while(atm.getBalance() >= needMoney) {
			atm.withdraw(name, needMoney);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ATM{
	private int balance;
	public void addMoney(int amount) {
		balance += amount;
	}
	public int getBalance() {
		return balance;
	}
//	public synchronized void withdraw(String name, int amount) {
	public void withdraw(String name, int amount) {
		synchronized (this) {
			if(balance < amount) return;
			System.out.printf("%s 인출 요청 (현재 잔액 %d) \n",name,balance);
			try {
				Thread.sleep(new Random().nextInt(301) + 700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= amount;
			System.out.printf("%s 인출 완료 (현재 잔액 %d) \n",name,balance);
			System.out.println("-------------------------------");
		}
	}
}

public class _06쓰레드이론05 {

	public static void main(String[] args) {

		ATM atm = new ATM();
		
		atm.addMoney(5000);
		Thread thr1 = new Thread(new CostomerRun("철수", atm, 500));
		Thread thr2 = new Thread(new CostomerRun("영희", atm, 300));
		Thread thr3 = new Thread(new CostomerRun("민수", atm, 400));
		thr1.start();
		thr2.start();
		thr3.start();
	}

}
