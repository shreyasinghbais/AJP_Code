package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
 
import dao.StudentDao;
import exception.StudentException;
import model.Student;
import utility.DAO;

public class StudentDaoImpl implements StudentDao{
	
	Connection con = null;
	PreparedStatement ppst = null;
	
	private Connection doSimple() throws SQLException{
		Connection c = null;
		try{
			
			c=DAO.getConnectionFactory().getConnection() ;
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return c;
	} 

	@Override
	public String addStudent(Student s) throws StudentException {
		// TODO Auto-generated method stub
		String msg = "Student is not registered";
		try {
			con = doSimple();
			ppst = con.prepareStatement(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String updateStudent(Student s) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(int studentId) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudent() throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

}
