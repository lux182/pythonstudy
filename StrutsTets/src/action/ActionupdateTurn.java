package action;

import MyBean.Dao;
import MyBean.cunqu;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import MyBean.cunqu;

public class ActionupdateTurn {
	
	private String xuehao;
	private String name;
	private String grade;
	

	public String getXuehao() {
		return xuehao;
	}


	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String execute() throws Exception{
		
		if(xuehao!=null){
			return "updateTurn";
		}
		else{
			return "fail";
		}
	}
}


