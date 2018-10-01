package project.action;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.glass.ui.View;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;

import Model.Member;
import sun.text.normalizer.ICUBinary.Authenticate;

public class RegisterAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Member member = null;
	private String from;
    private String password;
    
	private String to;
    private String subject;
    private String body;
    static Properties properties = new Properties();
    static
    {
       properties.put("mail.smtp.host", "smtp.gmail.com");
       properties.put("mail.smtp.socketFactory.port", "465");
       properties.put("mail.smtp.socketFactory.class",
                      "javax.net.ssl.SSLSocketFactory");
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.port", "465");
    }
 
	public String execute() throws Exception{
		return SUCCESS;
	}
	public String registerMember() throws Exception{
//		boolean insertRs = connection.oracle.AuthenticateMemberConnection.registerMember(member);
//		if(insertRs)
//			return SUCCESS;
		member.setVerifyCode(getRandomString());
//		return ERROR;
		int rs = connection.oracle.AuthenticateMemberConnection.registerMember(member);
		if(rs == 1)
			return SUCCESS;
		return INPUT;
	}
	public String checkExistByValue()
	{
		return SUCCESS;
	}
	//All functions
	public static String getRandomString()
	 {
	 	Integer charOfRandomLenght = 10;
	 	String randomString = RandomStringUtils.random(charOfRandomLenght, true, true); //create 8 characters String
	 	return randomString;
	 }
	// Getter and setter
	public Member getMember() {
		return this.member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getFrom() {
	      return from;
	   }

	   public void setFrom(String from) {
	      this.from = from;
	   }

	   public String getPassword() {
	      return password;
	   }

	   public void setPassword(String password) {
	      this.password = password;
	   }

	   public String getTo() {
	      return to;
	   }

	   public void setTo(String to) {
	      this.to = to;
	   }

	   public String getSubject() {
	      return subject;
	   }

	   public void setSubject(String subject) {
	      this.subject = subject;
	   }

	   public String getBody() {
	      return body;
	   }

	   public void setBody(String body) {
	      this.body = body;
	   }

	   public static Properties getProperties() {
	      return properties;
	   }

	   public static void setProperties(Properties properties) {
		   RegisterAction.properties = properties;
	   }
	

}
