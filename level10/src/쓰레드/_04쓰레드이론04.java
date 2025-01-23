package 쓰레드;

import java.util.Scanner;

class SingASong implements Runnable{

	int max;
	
	public SingASong(int max) {
		this.max = max;
	}


	@Override
	public void run() {
		String song = "%s : %d + %d는 귀요미";
		for(int i = 1 ; i <= max ; i++) {
			System.out.printf("%s \n",String.format(song, Thread.currentThread().getName(), i,i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("내 노래는 좋아");
				return;
			}
		}
	}
	
}

public class _04쓰레드이론04 {

	public static void main(String[] args) {

		Thread sas = new Thread(new SingASong(10));
		sas.setName("귀요미송");
		sas.start();
		try (Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				String input = sc.nextLine();
				if(input.equals("끝")) {
					System.out.println("노래가 끝났니?");
					System.out.println(sas.isAlive()? "아니" : "응");
				}
				if(input.equals("멈춰")) {
					System.out.println("노래가 시끄럽니?");
					sas.interrupt(); // interrupt Exception 발생시켜 캐치문 실행해줌
					break;
				}
				if(input.equals("같이")) {
					System.out.println("나도 같이 껴줘");
					try {
						sas.join(3000); // 비동기 -> 동기
					} catch (Exception e) {
					}
					System.out.println("---------------");
				}
			}
				
		} catch (Exception e) {
		}
	}

}
