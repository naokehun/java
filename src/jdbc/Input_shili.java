package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Input_shili {
	static Connection lianjie=null;
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO 自动生成的方法存根
		Class.forName("com.mysql.jdbc.Driver");
		lianjie=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc?characterEncoding=utf8","root","123456");
		
		File file=new File("E:\\大二\\Java\\tice");
		File[] wenjian_jihe=file.listFiles();
		System.out.println(wenjian_jihe.length);
		for (File file2 : wenjian_jihe) {
			System.out.println(file2);
			if (file2.getName().endsWith("xlsx")) {
				duqu_xlsx(file2);
			}else if (file2.getName().endsWith("xls")) {
				duqu_xls(file2);
			}	
		}
	}
	private static void duqu_xlsx(File wjm) throws IOException, ClassNotFoundException, SQLException {
		// TODO 自动生成的方法存根
		FileInputStream fin=new FileInputStream(wjm);
		XSSFWorkbook workbook=new XSSFWorkbook(fin);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows=sheet.getLastRowNum();
		System.out.println(rows);
		for(int i=0;i<rows;i++) {
			XSSFRow row=sheet.getRow(i);
			XSSFCell cell=row.getCell(3);
			String xuehao=cell.getStringCellValue();
	
			if (xuehao.equals("学号")) {
				continue;
			}
			//System.out.println(xuehao);	
			XSSFCell cell16=row.getCell(19);
			String zuo_shili=cell16.getStringCellValue();
			//System.out.println(zuo_shili);
			//System.out.println(you_shili);
			XSSFCell cell17=row.getCell(20);
			String you_shili=cell17.getStringCellValue();

	
				
			
			PreparedStatement ydy_yuju=lianjie.prepareStatement("update sheet1 set `左眼裸眼视力`=? `右眼裸眼视力`=? where `学号`=?");
			ydy_yuju.setString(1, zuo_shili);
			ydy_yuju.setString(2, you_shili);
			ydy_yuju.setString(3, xuehao);
			ydy_yuju.executeUpdate();
	}
}
	
	private static void duqu_xls(File wjm) throws IOException, ClassNotFoundException, SQLException {
		// TODO 自动生成的方法存根
		FileInputStream fin=new FileInputStream(wjm);
		HSSFWorkbook workbook=new HSSFWorkbook(fin);
		HSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows=sheet.getLastRowNum();
		for(int i=1;i<=rows;i++) {
			HSSFRow row=sheet.getRow(i);
			HSSFCell cell=row.getCell(3);
			String xuehao=cell.getStringCellValue();
			if (xuehao.equals("学号")) {
				continue;
			}
			System.out.println(xuehao);
			
			HSSFCell cell16=row.getCell(19);
			
			if(cell16!=null) {
				
			String zuo_shili=cell16.getStringCellValue();
			//System.out.println(zuo_shili);
			//System.out.println(you_shili);
			HSSFCell cell17=row.getCell(20);
			String you_shili=cell17.getStringCellValue();
			Class.forName("com.mysql.jdbc.Driver");
			
		
			PreparedStatement ydy_yuju=lianjie.prepareStatement("update  sheet1 set `左眼裸眼视力`=? `右眼裸眼视力`=? where `学号`=?");
			ydy_yuju.setString(1, zuo_shili);
			ydy_yuju.setString(2, you_shili);
			ydy_yuju.setString(3, xuehao);
			ydy_yuju.executeUpdate();
			}
		}
	}
}

