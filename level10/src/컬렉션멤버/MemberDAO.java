package 컬렉션멤버;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemberDAO {

	private List<Member> memberList;

	public static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance == null) instance = new MemberDAO();
		return instance;
	}
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	private MemberDAO() {
		memberList = new ArrayList<>();
	}
	public int getSize() {
		if(memberList.size() == 0)
			Utils.getInstance().showErrorMsg("데이터가 없습니다.");
		return memberList.size();
	}
	public boolean hasId(String id) {
		for(Member member : memberList)
			if(member.getId().equals(id))
				return true;
		return false;
	}
	public int getIdx(String id) {
		for(int i = 0 ; i < memberList.size();i++)
			if(memberList.get(i).getId().equals(id))
				return i;
		return -1;
	}
	public boolean isMatchPw(String id, String pw) {
		if(memberList.get(getIdx(id)).getPw().equals(pw))
			return true;
		return false;
	}
	public boolean isSameName(String id, String name) {
		if(memberList.get(getIdx(id)).getName().equals(name))
			return true;
		return false;
	}
	public void insertMember(String id, String pw, String name) {
		memberList.add(new Member(id, pw, name));
	}
	public void deleteMember(String id) {
		memberList.remove(getIdx(id));
	}
	public void printMember() {
		Collections.sort(memberList,new MemberComp(MemberComp.SortBy.ID, MemberComp.SortDir.ASC));
		for(Member member : memberList)
			System.out.println(member);
	}
	public void updateMember(String id, String name) {
		memberList.get(getIdx(id)).setName(name);
	}
	public void saveMember() {
		Utils.getInstance().savaDataToFile("member.txt", getData());
	}
	private String getData() {
		String data = "";
		Collections.sort(memberList,new MemberComp(MemberComp.SortBy.NAME, MemberComp.SortDir.ASC));
		System.out.println("==== [ 저장한 데이터 값 ] ====");
		for(Member member : memberList) {
			System.out.println(member);
			data += String.format("%s/%s/%s\n", member.getId(),member.getPw(),member.getName());
		}
		return data.substring(0,data.length() - 1);
	}
	public void loadMember(String data) {
		String[] datas = data.split("\n");
		memberList = new ArrayList<>();
		for(String str : datas) {
			String[] temp = str.split("/");
			insertMember(temp[0], temp[1], temp[2]);
		}
	}
	
}
