package july2.Aggregation.ex2;

public class Main {
	public static void main(String[] args) {
		// Creating a Professor object
        Prof p = new Prof("Dr. Jake Smith");

        // Creating a Department object and associating it with the Professor
        Department d = new Department("CSE", p);

        // Creating a University object and associating it with the Department
        University u = new University("XYZ University", d);

        // Printing the names
        System.out.println("University Name: " + u.getUniversity());
        System.out.println("Department Name: " + u.getD().getDept());
        System.out.println("Professor Name: " + u.getD().getProfessor().getName());
	}
}
