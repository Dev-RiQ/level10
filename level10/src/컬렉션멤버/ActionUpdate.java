package 컬렉션멤버;

public class ActionUpdate implements Action {

	@Override
	public void excute() {
		if(MemberDAO.getInstance().getSize() == 0) return;
		System.out.println("==== [ 정보수정 ] ====");
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
		String name = Utils.getInstance().getValue("변경할 name 입력 >> ");
		if(MemberDAO.getInstance().isSameName(id,name)) {
			Utils.getInstance().showErrorMsg("기존 이름과 동일한 입력입니다.");
			return;
		}
		MemberDAO.getInstance().updateMember(id, name);
		
		System.out.println("==== [ 이름수정 성공 ] ====");
		
	}

}
