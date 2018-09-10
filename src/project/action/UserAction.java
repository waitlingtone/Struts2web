package project.action;

import java.util.HashMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaClientTube;

import java.util.*;

import Model.*;


public class UserAction extends ActionSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Profile memProfile = null;

	public String profile() {
		
		return SUCCESS;
	}

	public Profile getMemProfile() {
		return memProfile;
	}
	public void setMemProfile(Profile memProfile) {
		this.memProfile = memProfile;
	}


}
