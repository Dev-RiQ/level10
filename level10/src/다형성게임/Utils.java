package 다형성게임;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
	private Utils() {
	}

	private static Utils instance;

	public static Utils getInstance() {
		if (instance == null)
			instance = new Utils();
		return instance;
	}

	private Scanner sc = new Scanner(System.in);

	/** 에러 메세지 출력 */
	public void showErrorMsg(String msg) {
		System.err.println("[ 메세지 ] : " + msg);
	}

	/** nextInt() 입력 받기 */
	public int getValue(String msg, int start, int end) {
		int value = 0;
		while (true) {
			try {
				value = getInteger(msg, start, end);
				return value;
			} catch (InputMismatchException e) {
				showErrorMsg("int 타입의 정수를 입력하세요.");
			} catch (Exception e) {
				showErrorMsg(String.format("%d~%d 사이의 정수 값을 입력해주세요. \n", start, end));
			} finally {
				sc.nextLine();
			}
		}
	}

	/** nextInt() 입력 */
	private int getInteger(String msg, int start, int end) throws Exception {
		System.out.print(msg);
		int value = sc.nextInt();
		if (value < start || value > end)
			throw new Exception();
		return value;
	}

	/** nextLine() 입력 받기 */
	public String getValue(String msg) {
		String value = null;
		while (true) {
			try {
				value = getString(msg);
				return value;
			} catch (InputMismatchException e) {
				showErrorMsg("빈칸은 입력 불가능합니다.");
			} catch (NullPointerException e) {
				showErrorMsg("띄어쓰기는 입력할 수 없습니다.");
			} catch (Exception e) {
				showErrorMsg("잘못된 입력입니다.");
			}
		}
	}

	/** nextLine() 입력 */
	private String getString(String msg) throws Exception {
		System.out.print(msg);
		String value = sc.nextLine();
		if (value.isBlank())
			throw new InputMismatchException();
		else if (value.contains(" "))
			throw new NullPointerException();
		return value;
	}

}
