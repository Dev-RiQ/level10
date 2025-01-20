package 컬렉션멤버;

public class ActionDelete implements Action {

	@Override
	public void excute() {
		if(MemberDAO.getInstance().getSize() == 0) return;
		System.out.println("==== [ 회원삭제 ] ====");
		String id = Utils.getInstance().getValue("id 입력 >> ");
		if(!MemberDAO.getInstance().hasId(id)) {
			Utils.getInstance().showErrorMsg("존재하지 않는 id입니다.");
			return;
		}
		String pw = Utils.getInstance().getValue("pw 입력 >> ");
		if(!MemberDAO.getInstance().isMatchPw(id,pw)) {
			Utils.getInstance().showErrorMsg("일치하지 않는 pw입니다.");
			return;
		}
		MemberDAO.getInstance().deleteMember(id);
		
		System.out.println("==== [ 회원삭제 성공 ] ====");
		
	}

}
