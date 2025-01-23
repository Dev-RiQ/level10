package 쓰레드;

class Thread1 extends Thread{
	
	@Override
	public void run() {
		for(int i = 1 ; i<=20; i++) {
			try {
				sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(1);
		}
	}
}

class myRunnable implements Runnable{

	@Override
	public void run() {
		for(int i = 1 ; i<=20; i++) {
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(2);
		}
	}
	
}

public class _01쓰레드이론 {

	// 동기적 : 메모리 호출 순서대로 실행, 현재 실행하는거 멈추고 호출된거 실행
	// 비동기적 : 호출될때 다른곳에서 실행, 현재 실행하는 것을 멈추지 않는다
	
	public static void main(String[] args) {

		System.out.println("메인 쓰레드 영역");
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread(new myRunnable());
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1 ; i<=20; i++) {
					try {
						Thread.sleep(300);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("3");
				}				
			}
		});
		
		Thread thread4 = new Thread(() -> {
			for(int i = 1 ; i<=20; i++) {
				try {
					Thread.sleep(300);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("4");
			}				
		});
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		for(int i = 1 ; i<=20; i++) {
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("M");
		}
	}

}
