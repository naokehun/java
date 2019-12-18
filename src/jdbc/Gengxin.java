package jdbc;

import java.sql.*;

public class Gengxin {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO 自动生成的方法存根
		Class.forName("com.mysql.jdbc.Driver");
		//获得链接
		Connection lianjie=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc","root","123456");
		//通过连接对象获取语句对象
		Statement yuju=lianjie.createStatement();
		//定义更新sql语句
		String sql="UPDATE tb_user SET email='jacak@qq.com' WHERE ID=1";
		//通过语句对象执行sql
		yuju.execute(sql);
	}

}
