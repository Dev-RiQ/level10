package 컬렉션멤버;

import java.util.HashMap;
import java.util.Map;

public class Controller {

	private Map<Menu, Action> mapList;
	public static Controller instance;
	public static Controller getInstance() {
		if(instance == null) instance = new Controller();
		return instance;
	}
	private Controller() {
		mapList = new HashMap<>();
		mapList.put(Menu.INSERT, new ActionInsert());
		mapList.put(Menu.DELETE, new ActionDelete());
		mapList.put(Menu.UPDATE, new ActionUpdate());
		mapList.put(Menu.PRINT, new ActionPrint());
		mapList.put(Menu.SAVE, new ActionSave());
		mapList.put(Menu.LOAD, new ActionLoad());
	}
	private Action getAction(Menu key) {
		return mapList.get(key);
	}
	
	public void run() {
		while(true) {
			System.out.println("================== 메뉴 ==================");
			System.out.println("1) 추가"); // id중복제거
			System.out.println("2) 삭제"); // id로 삭제
			System.out.println("3) 수정"); // id,pw맞으면 이름 수정
			System.out.println("4) 출력"); // 이름순 출력
			System.out.println("5) 저장"); // member.txt 저장 => id순 저장
			System.out.println("6) 로드"); // member.txt 로드
			System.out.println("0) 종료");
			int sel = Utils.getInstance().getValue("메뉴 선택 >> ", 0, 6);
			if(sel == 1)
				getAction(Menu.INSERT).excute();
			if(sel == 2)
				getAction(Menu.DELETE).excute();
			if(sel == 3)
				getAction(Menu.UPDATE).excute();
			if(sel == 4)
				getAction(Menu.PRINT).excute();
			if(sel == 5)
				getAction(Menu.SAVE).excute();
			if(sel == 6)
				getAction(Menu.LOAD).excute();
			if(sel == 0)
				break;
				
		}
	}
}
