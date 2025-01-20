package 컬렉션멤버;

public class ActionInsert implements Action {

	@Override
	public void excute() {
		System.out.println("==== [ 회원가입 ] ====");
		String id = Utils.getInstance().getValue("id 입력 >> ");
		if(MemberDAO.getInstance().hasId(id)) {
			Utils.getInstance().showErrorMsg("중복된 id입니다.");
			return;
		}
		String pw = Utils.getInstance().getValue("pw 입력 >> ");
		String name = Utils.getInstance().getValue("name 입력 >> ");
		
		MemberDAO.getInstance().insertMember(id, pw, name);
		System.out.println("==== [ 회원가입 성공 ] ====");
	}

}
