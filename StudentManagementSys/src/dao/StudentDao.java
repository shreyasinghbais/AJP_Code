package dao;

import java.util.List;

import exception.StudentException;
import model.Student;

public interface StudentDao {
	public String addStudent (Student s) throws StudentException; 
	public String updateStudent (Student s) throws StudentException; 
	public String deleteStudent (int studentId) throws StudentException; 
	public List<Student> getAllStudent() throws StudentException; 
	
}
