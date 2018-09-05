package project.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		String member_session = (String)session.get("member.login");
		if(member_session == null || member_session.equals("")) {
			return Action.LOGIN;
		}else {
			return invocation.invoke();
		}
	}

}
