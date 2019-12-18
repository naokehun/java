package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class Putong {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO 自动生成的方法存根
		Class.forName("com.mysql.jdbc.Driver");
		//获得链接
		Connection lianjie=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc","root","123456");
		//通过连接对象获取语句对象
		Statement yuju=lianjie.createStatement();
		//定义更新sql语句
		String sql="select * from tb_user";
		ResultSet rs=yuju.executeQuery(sql);
		System.out.println("id     |   name     |    +sex");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name=rs.getString("name");
			String sex=rs.getString("sex");
			System.out.println(id+"   |   "+name+"");
			
		}
	}

}
