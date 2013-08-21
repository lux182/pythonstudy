package action;

import MyBean.Dao;
import MyBean.cunqu;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import MyBean.cunqu;

public class ActionDelete {


	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh[] = request.getParameterValues("Sxh");
		    Connection connection = null;
		    Statement stmt = null;
		    int rows=0;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/good","root", "123");
		if (connection != null) {
		stmt = connection.createStatement();
		for(int i = 0;i<xh.length;i++){
	        String sql ="delete from stu where Sid='"+xh[i]+"'";
	rows = stmt.executeUpdate(sql);
	}
	if (rows == 1) {
	return "delete";
	               } 
	else{
	return "fail";
	}
	       }
	       }
	    catch (SQLException e){	
	}
	return null;
	}
}