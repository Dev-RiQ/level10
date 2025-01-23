package 쓰레드;

class BGMPlay extends Thread{
	
	boolean isPlay = true;
	
	@Override
	public void run() {
		while(isPlay) {
			System.out.println("배경음악이 연주되는 중");
			try {
				sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class _02쓰레드이론2 {

	public static void main(String[] args) {

		BGMPlay bgmplay = new BGMPlay();
		bgmplay.start();
		for(int i = 1 ; i <= 10 ; i++) {
			System.out.println("신나게 게임하는 중 ^-^");
			if(i == 8) {
				System.out.println("앗 엄크 이슈");
				System.out.println("게임 종료 ㅜㅜ");
				bgmplay.isPlay = false;
				break;
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
