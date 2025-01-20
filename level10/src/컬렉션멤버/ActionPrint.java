package 컬렉션멤버;

public class ActionPrint implements Action {

	@Override
	public void excute() {
		if(MemberDAO.getInstance().getSize() == 0) return;
		System.out.println("==== [ 회원목록 ] ====");
		MemberDAO.getInstance().printMember();
		System.out.println("==== [ 출력 완료 ] ====");
	}

}
