package model;

import java.util.ArrayList;

public class MemberDAO {
	static ArrayList<MemberDTO> list = new ArrayList<>();
	
	// 비즈니스 로직
	// 멤버 저장
	public ArrayList<MemberDTO> memberJoin(MemberDTO dto){
		list.add(dto);
		
		return list;
	}
}
