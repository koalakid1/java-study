package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC1 {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","1234");
			System.out.println("DB 연결 완료");
			
			stmt = conn.createStatement();
			
			//stmt.executeUpdate("insert into student values('0000001','세종','국문학과')");

//			stmt.executeUpdate("update student set name='세종대왕' where id = '0000001'");
			
//			stmt.executeUpdate("delete from student where id = '0000001'");
			
			rs = stmt.executeQuery("select * from student");
			while(rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("dept"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
}
