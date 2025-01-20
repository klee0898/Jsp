package frontController;

import java.util.HashMap;
import java.util.Map;

import controller.AdminLoginOk;
import controller.Controller;
import controller.Move;


public class ActionMapping {
	private Map<String, Controller> actionMap = new HashMap<>();
	
	public ActionMapping() {
		// 홈
		//actionMap.put("/", new Home());
		
		// 관리자 관련 매핑
		actionMap.put("/adminLogin.do", new Move());
		actionMap.put("/adminLoginOk.do", new AdminLoginOk());
		/*actionMap.put("/list.do", new List());
		actionMap.put("/view.do", new View());
		actionMap.put("/delete.do", new Delete());
		actionMap.put("/update.do", new Update());
		actionMap.put("/replyView.do", new ReplyView());
		actionMap.put("/addReply.do", new AddReply());*/
		
	/*	// 사용자관련 매핑		
		actionMap.put("/memberJoin.do", new MemberJoin());
		actionMap.put("/memberList.do", new MemberList());
		actionMap.put("/memberInsert.do", new MemberInsert());
		actionMap.put("/memberInfo.do", new MemberInfo());
		actionMap.put("/memberDelete.do", new MemberDelete());
		actionMap.put("/memberUpdate.do", new MemberUpdate());
	*/
	}
	
	
	public Controller getController(String cmd) {
		return actionMap.get(cmd);
	}
}
