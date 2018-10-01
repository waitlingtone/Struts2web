package project.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Model.Member;
import connection.oracle.AuthenticateMemberConnection;
import connection.oracle.ConnectionDAO;

public class EmailerAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 String from = "struts2webpage@gmail.com";
	 String password = "@a123456789";
	 private String to;
	 private String subject;
	 private String body;
	 private String codeField;
	 private Map<String, Object> session = ActionContext.getContext().getSession();
	 
	 Member member = new Member();
	 ActionContext actionContext = ActionContext.getContext();
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

	public String sendEmailToMember()
	{
		
		 String result = SUCCESS;
		 System.out.println(to);
	       try
	       {
	    	   Authenticator admin = new Authenticator() {
	    		   protected PasswordAuthentication 
		              getPasswordAuthentication() {
		              return new
		              PasswordAuthentication(from, password);
	    		   }
	    	  };
	          Session session = Session.getDefaultInstance(properties, admin);
	          Message message = new MimeMessage(session);
	          message.setFrom(new InternetAddress(from));
	          message.setRecipients(Message.RecipientType.TO,  InternetAddress.parse(to));
	          setSubject("Verify Code For You");
	          setBody("Emailbody");
	          setBody(makeEmailBody(member.getVerifyCode()));
	          System.out.println(member.getVerifyCode());
	          System.out.println(member.getMemberId());
	          System.out.println(body);
	          actionContext.put("emailInUse", to);
	          System.out.println((String)actionContext.get("emailInUse"));
	          message.setSubject(subject);
	          message.setText(body);
	          Transport.send(message);
	       }
	       catch(Exception e)
	       {
	          result = ERROR;
	          e.printStackTrace();
	       }
	       return result;
}
public String createHashString() throws Throwable {
	System.out.println(member.getVerifyCode());
	return INPUT;
}
public String checkVerifyCode() throws SQLException {
	String rs = ERROR;
	Integer result = AuthenticateMemberConnection.isSuccessCheckCode(codeField, member.getEmail());
	System.out.println(codeField);

	
	if(result == 1)
	{	
		try {
			ResultSet rSet;
			String query = "SELECT ID FROM MEMBER WHERE EMAIL = ? ";
			PreparedStatement pStatement = ConnectionDAO.connection().prepareStatement(query);
			pStatement.setString(1, member.getEmail());
			rSet = pStatement.executeQuery();
			while(rSet.next())
			{
				member.setMemberId(rSet.getInt("ID"));
				session.put("memberId", member.getMemberId());
			}
			
			
			rs = SUCCESS;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			ConnectionDAO.connection().close();
		}
		
	}
	return rs;
};
//function

/* Hàm Hash verify code */
//public String getHashCode(String randomString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//	MessageDigest messageDigest;
//	String encryptString = "";
//	try {
//        messageDigest = MessageDigest.getInstance("SHA-256");
//        messageDigest.update(randomString.getBytes("UTF-8"));
//    } catch (NoSuchAlgorithmException e) {
//        throw e;
//    } catch (UnsupportedEncodingException e) {
//        throw e;
//    }
//	byte byteHash[] = messageDigest.digest();
//	int byteLenght = byteHash.length;
//	for(int i =0; i < byteLenght; i++)
//	{
//		encryptString += Integer.toHexString(byteHash[i] & 0xff);
//	}
////	encryptString = new String(messageDigest.digest());
//	//String uuid = UUID.randomUUID().toString();
//	//System.out.println("uuid = " + uuid);
//	return encryptString;
//}
public String makeEmailBody(String randomString)
{	
	String bodyMail = "";
	bodyMail += "Verify your Account."
			+ "Your Actvation Code (10 digits):"+ randomString;
	return bodyMail;
	
}
//Getter and Setter
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
    EmailerAction.properties = properties;
 }
 public Member getMember() {
	return member;
}
public void setMember(Member member) {
	this.member = member;
}
public String getCodeField() {
	return codeField;
}
public void setCodeField(String codeField) {
	this.codeField = codeField;
}
public Map<String, Object> getSession() {
	return session;
}
public void setSession(Map<String, Object> session) {
	this.session = session;
}


}
