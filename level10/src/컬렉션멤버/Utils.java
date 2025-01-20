package 컬렉션멤버;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
	private final String CUR_PATH = System.getProperty("user.dir") + "\\src\\" + Utils.class.getPackageName() + "\\";

	/** 일반 메세지 출력 */
	public void showMsg(String msg) {
		System.out.println("[ 메세지 ] : " + msg);
	}

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

	/** 데이터 저장하기 */
	public void savaDataToFile(String fileName, String allListToData) {
		if (allListToData == null)
			return;
		try (FileWriter fw = new FileWriter(CUR_PATH + fileName)) {
			fw.write(allListToData);
			showMsg(fileName + "저장 성공");
		} catch (Exception e) {
			showErrorMsg(fileName + "저장 실패");
		}
	}

	/** 파일 불러오기 */
	public String loadDataToFile(String fileName) {
		if (!new File(CUR_PATH + fileName).exists()) {
			showErrorMsg(fileName + "저장된 파일이 없습니다.");
			return null;
		}
		String data = "";
		try (FileReader fr = new FileReader(CUR_PATH + fileName); BufferedReader br = new BufferedReader(fr)) {
			data += getData(br);
			showMsg(fileName + "불러오기 성공");
		} catch (Exception e) {
			showErrorMsg(fileName + "불러오기 실패");
		}
		return data;
	}

	/** 로드 데이터 String화 */
	private String getData(BufferedReader br) throws Exception {
		String data = "";
		while (true) {
			String temp = br.readLine();
			if (temp == null)
				break;
			data += temp + "\n";
		}
		return data;
	}
}
