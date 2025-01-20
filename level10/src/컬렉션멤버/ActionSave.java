package 컬렉션멤버;

public class ActionSave implements Action {

	@Override
	public void excute() {
		if(MemberDAO.getInstance().getSize() == 0) return;
		MemberDAO.getInstance().saveMember();
	}

}
