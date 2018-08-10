package waitlingtone.zylphir.action;

public class HelloAction {

		private String name;
		
		public String execute() throws Exception{
			if(this.name.isEmpty())
				return "error";
			return "success";
		}
		public String executediff() throws Exception {
			setName("Bye !!");
			return "ok";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
}
