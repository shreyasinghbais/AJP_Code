package crud.Demo;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import crud.utility.ConnectionFactory;

//import crud.utility.ConnectionFactory;

public class StudentCrudOperation { 
	
	Connection con = null;
	PreparedStatement ppst = null;
	ResultSet rs = null;
	
	public Connection doSimple() throws SQLException{
		Connection c = null;
		try{
			c=ConnectionFactory.getConnectionFactory().getConnection() ;	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return c;
	} 
		
	// CRUD  - create , read   , update  , delete 
	public void addStudent(Student s ) {
			
		try {
			String queryString = "insert into student values(?, ? ,?)"; 
			con = doSimple();
		    ppst  = con.prepareStatement(queryString) ;
			ppst.setInt(1, s.getStudent_id());
			ppst.setString(2, s.getStudent_name()) ;
			ppst.setInt(3,  s.getStudent_marks()) ;
				
			int ans  = ppst.executeUpdate() ; //  insert data in single row
				
			if (ans != 0) {
				System.out.println("data got inserted succesfully ");
			}else {
				System.out.println("some thing went wrong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ppst !=  null) {
					ppst.close();

				}
				if (con != null) {
					con.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	//update
	public void updateData(Student s) { 
		try {
			String queryString = "update Student set smarks  = ? where  sid =  ? ";
			con= doSimple() ;
			ppst  =  con.prepareStatement(queryString);
			ppst.setInt(1, s.getStudent_marks());
			ppst.setInt(2, s.getStudent_id());
	        int	ans = ppst.executeUpdate() ;
	        if (ans != 0) {
				System.out.println("data got updated succesfully ");
			}else {
				System.out.println("some thing went wrong");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			try {
				if (ppst !=  null) {
					ppst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	//delete
	public void deleteData(int sid) {
		try {
			String queryString = "DELETE FROM student WHERE sid=?";
			con = doSimple();
			ppst = con.prepareStatement(queryString);
			ppst.setInt(1, sid);
			int	ans = ppst.executeUpdate();
			if (ans != 0) {
				System.out.println("data got deleted succesfully ");
			}else {
				System.out.println("some thing went wrong");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppst !=  null) {
					ppst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	//read
	public void readData() {
		ArrayList<Student> listOfStudent = new ArrayList<>() ;
		try {
			String queryString = "SELECT * FROM student";
			con = doSimple();
			ppst = con.prepareStatement(queryString);
			rs = ppst.executeQuery(); 
			while(rs.next()) {
				listOfStudent.add(new Student(rs.getInt(1) ,rs.getString(2 ) ,rs.getInt(3) )) ; 
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ppst !=  null) {
					ppst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		listOfStudent.forEach(System.out::println) ;
		//System.out.println(listOfStudent);
	} 
}
