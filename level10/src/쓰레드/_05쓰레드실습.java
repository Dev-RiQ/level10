package 쓰레드;

import java.text.SimpleDateFormat;
import java.util.Scanner;

class InputMachine implements Runnable {

	private Scanner sc = new Scanner(System.in);
	public static String input = "";

	@Override
	public void run() {
		System.out.println("Input");
		System.out.println("StopWatch");
		System.out.println(">>>>");

		while (sc.hasNext()) {
			String temp = sc.nextLine();
			if (temp.equals("x")) {
				input = temp;
				return;
			} else if (temp.equals("q")) {
				input = temp;
				return;
			} else if (temp.equals("h")) {
				input = input.equals("h") ? "" : "h";
			}
		}
	}
}

class StopWatch implements Runnable {

	private int time;

	@Override
	public void run() {
		String checkTime = "";
		System.out.println("[q] quit [h] hold [x] return");
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String input = InputMachine.input;
			if (input.equals("x") || input.equals("q")) {
				if (input.equals("q"))
					System.out.println("소요 시간 : " + checkTime);
				System.out.println("종료");
				break;
			}
			if (!input.equals("h")) {
				time++;
				String printTime = new SimpleDateFormat("hh:mm:ss").format(System.currentTimeMillis());
				checkTime = time > 60 ? String.format(" [ %2d분 %2d초 ]", time / 60, time % 60)
						: String.format(" [ %2d초 ]", time);
				System.out.println(printTime + checkTime);
			}
		}
	}
}

public class _05쓰레드실습 {

	public static void main(String[] args) {

		Thread threadStopWatch = new Thread(new StopWatch());
		Thread threadInput = new Thread(new InputMachine());
		threadInput.start();
		threadStopWatch.start();

	}

}
