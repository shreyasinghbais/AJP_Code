package crud.Demo;

public class SingletonClassExample {
	
	private static SingletonClassExample instance;
	
	private SingletonClassExample() {
		super();
	}
	
	public static SingletonClassExample getInstance() {
		if(instance==null) {
			instance = new SingletonClassExample();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		SingletonClassExample c1 = SingletonClassExample.getInstance();
		SingletonClassExample c2 = SingletonClassExample.getInstance();
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
}
