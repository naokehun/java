package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ShiliInput {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO 自动生成的方法存根
		FileInputStream fin=new FileInputStream("shili.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fin);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows=sheet.getLastRowNum();
		for(int i=1;i<=rows;i++) {
			XSSFRow row=sheet.getRow(i);
			XSSFCell cell=row.getCell(3);
			String xuehao=cell.getStringCellValue();
			System.out.println(xuehao);
			
			XSSFCell cell16=row.getCell(15);
			String zuo_shili=cell16.getStringCellValue();
			//System.out.println(zuo_shili);
			//System.out.println(you_shili);
			XSSFCell cell17=row.getCell(16);
			String you_shili=cell17.getStringCellValue();
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection lianjie=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bbb?characterEncoding=utf8","root","123456");
			PreparedStatement ydy_yuju=lianjie.prepareStatement("update 18rj2 set `左眼裸眼视力`=? `右眼裸眼视力`=? where `学号`=?");
			ydy_yuju.setString(1, zuo_shili);
			ydy_yuju.setString(2, you_shili);
			ydy_yuju.setString(3, xuehao);
			ydy_yuju.executeUpdate();
			
		}
	}

}
