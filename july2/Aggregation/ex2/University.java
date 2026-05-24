package july2.Aggregation.ex2;

public class University {
	String university;
	Department d;
	public University(String university, Department d) {
		super();
		this.university = university;
		this.d = d;
	}
	public String getUniversity() {
		return university;
	}
	public Department getD() {
		return d;
	}
}
