package 쓰레드;

class ExThread implements Runnable{

	int no;
	public ExThread(int no) {
		this.no = no;
	}
	
	@Override
	public void run() {
		System.out.println("쓰레드 이름 : "+Thread.currentThread().getName());
		for(int i = 0 ; i < 20 ; i++) {
			System.out.println(no);
			for(int k = 0 ; k <Integer.MAX_VALUE; k++) {}
		}
	}
	
}

public class _03쓰레드이론03 {

	public static void main(String[] args) {

		Thread thread1 = new Thread(new ExThread(1));
		Thread thread2 = new Thread(new ExThread(2));
		Thread thread3 = new Thread(new ExThread(3));
		
		thread1.setName("쓰레드1");
		thread2.setName("쓰레드2");
		thread3.setName("쓰레드3");
		
		// jvm 쓰레드 우선순위 권장
		// 근데 실제 컨트롤은 OS CPU에서 처리해서 잘 안됨
		
		thread1.setPriority(Thread.MIN_PRIORITY); // 1
		thread2.setPriority(Thread.NORM_PRIORITY); // 5 (기본)
		thread3.setPriority(Thread.MAX_PRIORITY); // 10
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		
	}

}
