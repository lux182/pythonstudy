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

public class ActionUpdate {
	
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
		String id=ServletActionContext.getRequest().getParameter("xuehao");
		String name=ServletActionContext.getRequest().getParameter("name");
		String grade=ServletActionContext.getRequest().getParameter("grade");
		
		
		

		Dao dao = new Dao();


			int rows = 0;
			try {
				rows=dao.xiugai(xuehao,name,grade);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

		if(rows==1){
			return "update";
		}
		else{
			return "fail";
		}
	}
}


