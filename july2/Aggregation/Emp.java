package july2.Aggregation;

public class Emp {
	int id;  
	String name;  
	Address address;  
	  
	public Emp(int id, String name,Address address) {  
	    this.id = id;  
	    this.name = name;  
	    this.address=address;  
	}  
	  
	void display(){  
	System.out.println(id+" "+name+" "+address.city+", "+address.state+", "+address.country);  
	System.out.println();  
	}  
	
	public static void main(String[] args) {   
		Emp e=new Emp(111,"varun", new Address("Indore", "MP", "India"));  
		Emp e1=new Emp(111,"varun", new Address("Bhopal", "MP", "India"));  
		      
		e.display();  
		e1.display(); 
	}
}
