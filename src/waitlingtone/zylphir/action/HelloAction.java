package waitlingtone.zylphir.action;
import com.opensymphony.xwork2.ActionSupport;
public class HelloAction extends ActionSupport{

		private String username, password;
		
		public String execute() throws Exception{
			return SUCCESS;
		}
		public String executediff(){
			return "ok";
		}
		public String getUserName() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}
