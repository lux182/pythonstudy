package MyBean;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class Dao {
	
private Connection getConnection()  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "public");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public ResultSet get(String sql){
		Connection connection = this.getConnection();
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs; 
	}
	
	
	public int shanchu(String xuehao) throws Exception{
		
		Connection connection = this.getConnection();
		Statement stm = connection.createStatement();
	
		String sql = "delete from stu where Sid ='"+xuehao+"'";
		int rows = stm.executeUpdate(sql);
		if (rows==1){
			System.out.println("ɾ���ɹ�");	
		}
		return rows;
	}
	
	
	
	public int xiugai(String xuehao,String name,String grade) throws Exception{
		Connection connection = this.getConnection();
		Statement stm = connection.createStatement();
	    String sql ="update stu set Name='"+name+"',Grade='"+grade+"' where Sid='"+xuehao+"'";
		int rows = stm.executeUpdate(sql);
		if(rows==1){
			System.out.println("�޸ĳɹ�");
		}
		return rows;
	}
	
	public int tianjia(String xuehao,String name,String grade) throws Exception{
		Connection connection = this.getConnection();
		Statement stm = connection.createStatement();
		
		String sql ="insert into stu(Sid,Name,Grade) values('"+xuehao+"','"+name+"','"+grade+"')";
		
		int rows = stm.executeUpdate(sql);
		if(rows==1){
			System.out.println("��ӳɹ�");
		}
	    return rows;
	}
 
//	public int AllDelete(String[] xh) throws Exception{
//		Connection connection = this.getConnection();
//		Statement stm = connection.createStatement();
//		HttpServletRequest request = ServletActionContext.getRequest(); 
//		
//	
//		for(int i = 0;i<xh.length;i++){
//		String sql = "delete from stu where Sid ='"+xh[i]+"'";
//		int rows=0;
//		rows = stm.executeUpdate(sql);
//		if (rows==1){
//			System.out.println("ɾ���ɹ�");	
//		}
//		return rows;	
//	}	
//}
}


