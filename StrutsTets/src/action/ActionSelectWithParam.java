package action;

import MyBean.Dao;


import MyBean.cunqu;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;



public class ActionSelectWithParam {


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
		ServletRequest request=ServletActionContext.getRequest(); 
	    String xuehao=request.getParameter("xuehao"); 
	    System.out.print(xuehao); 
		String sql = "select * from stu where Sid ="+xuehao;
		Dao dao = new Dao();
		ResultSet rs = dao.get(sql);
		ArrayList<cunqu> notes = new ArrayList<cunqu>();
	try{
			while(rs.next()){
			cunqu tn = new cunqu();
			tn.setXuehao(rs.getString("Sid"));
			tn.setName(rs.getString("Name"));
			tn.setGrade(rs.getString("Grade"));
			notes.add(tn);
	}
			HttpSession session = ServletActionContext.getRequest().getSession();  

			session.setAttribute("ListAll", notes); 
			
	}catch(SQLException e){
		e.printStackTrace();
	}
	return "success"; 
	} 

}


