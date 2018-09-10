package project.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

import org.apache.struts2.ServletActionContext;

import Model.*;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;


public class UserAction extends ActionSupport implements ModelDriven<Member>{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Profile memProfile = null;
	private Member member = new Member();
	public String home() { 
		
		return SUCCESS;
	}


	public String profile() {
		
		return SUCCESS;
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Profile getMemProfile() {
		return memProfile;
	}
	public void setMemProfile(Profile memProfile) {
		this.memProfile = memProfile;
	}

	@Override
	public Member getModel() {
		// TODO Auto-generated method stub
		return member;
	}	
}
