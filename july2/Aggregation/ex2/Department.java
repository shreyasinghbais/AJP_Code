package july2.Aggregation.ex2;

public class Department {
	String dept;
	Prof prof;
	public Department(String dept, Prof prof) {
		super();
		this.dept = dept;
		this.prof = prof;
	}
	public String getDept() {
        return dept;
    }

    public Prof getProfessor() {
        return prof;
    }
}
