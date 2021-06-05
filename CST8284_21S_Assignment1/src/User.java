
public class User {
	
	private static int userNextId = 1000;
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	
	public User(int id, String firstName, String lastName, String address, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		
	}
	
	public User( String firstName, String lastName, String address, int age) {
		this(1000,firstName,lastName,address,age);
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		
	}
	
	public User( String first, String last, String address) {
		this(first, last,address, 18);
		this.firstName = first;
		this.lastName = last;
		this.address = address;				
	}
	
	@Override
	public String toString() {
		String msg = "";
		msg = "************ User id:" + getId()+ "\n";
		msg += "************ User name:" + getFirstName() +" "+ getLastName()+ "\n";
		msg += "************ Age:" + getAge()+ "\n";
		msg += "************ Address:" + getAddress()+ "\n";
		
		System.out.printf(msg);

		return msg;
	}

	
	/**
	 * is a static counter that increments each time a User object is created. The current
	 *	value is assigned to the id of the new User object and is then incremented by 1.
	 *	If a User is created without age, it defaults to 18.
	 *	Use constructor overloading and constructor chaining.
	 * @return
	 */
	public static int getUserNextId() {
		return userNextId + 1;
	}

	public static void setUserNextId(int userNextId) {
		User.userNextId = userNextId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
