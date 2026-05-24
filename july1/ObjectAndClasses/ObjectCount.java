package july1.ObjectAndClasses;

public class ObjectCount {
	private static int objCount = 0;
	
	public ObjectCount() {
		objCount++;
	}
	
	public static int getObjectCount() {
		return objCount;
	}
	
	public static void main(String[] args) {
		ObjectCount o1 = new ObjectCount();
		ObjectCount o2 = new ObjectCount();
		ObjectCount o3 = new ObjectCount();
		ObjectCount o4 = new ObjectCount();
		ObjectCount o5 = new ObjectCount();
		
		System.out.println("Count of Objects : " + ObjectCount.getObjectCount());
	}
}
