package 컬렉션멤버;

public class ActionLoad implements Action {

	@Override
	public void excute() {
		String data = Utils.getInstance().loadDataToFile("member.txt");
		if(data == null) return;
		MemberDAO.getInstance().loadMember(data);
	}

}
