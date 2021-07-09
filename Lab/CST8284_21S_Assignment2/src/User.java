
/**
 * 
 * Course Name: CST8284
 * Author Name: Ming Wang 
 * Class Name: 300 
 * Date:Jul 14, 2021
 * Description: Class User with firstName, lastName ,id, address, and age
 * besides the constructor and getter and setter.it include 
 * an override toString method 
 */

/**
 * This class is a User class. every user object will create and save in this class 
 * due to the teacher's instruction, I make 3 constructors with and chain them together
 *  no default instructor.
 */

public class User {

	private static int userNextId = 1000;
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	private final int DEFAULT_AGE = 18;

	/**
	 * constructor with all fields
	 * @param id  user's id, default 1000
	 * @param firstName user's first name 
	 * @param lastName	user's last name
	 * @param address	user's address
	 * @param age		user's age, default 18
	 */
	public User(int id, String firstName, String lastName, String address, int age) {
		this.id = userNextId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		userNextId++;
	}

	/**
	 * constructor with 4 fields, will call the constructor with 5 fields
	 * @param firstName user's first name 
	 * @param lastName	user's last name
	 * @param address	user's address
	 * @param age		user's age, default 18
	 */
	public User(String firstName, String lastName, String address, int age) {
		this(userNextId, firstName, lastName, address, age);
	
		if(age < DEFAULT_AGE) {
			this.age = DEFAULT_AGE;
		}else {
			this.age = age;
		}		
	}

	/**
	 * constructor with 3 fields, will call the constructor with 4 fields
	 * @param firstName user's first name 
	 * @param lastName	user's last name
	 * @param address	user's address

	 */
	public User(String first, String last, String address) {
		this(first, last, address, userNextId);
	
	}

	/**
	 * this override toString method is used to output the user's information
	 * @return formating String message
	 */

	@Override
	public String toString() {
		String msg = "";
		msg = "************ User id:" + getId() + "\n";
		msg += "************ User name:" + getFirstName() + " " + getLastName() + "\n";
		msg += "************ Age:" + getAge() + "\n";
		msg += "************ Address:" + getAddress() + "\n";
		return msg;
	}
	

	/**
	 * override equals method to verify if two users are equal
	 * @return true for two users are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null && (! (obj instanceof User))) {
			return false;
		}
		User user = (User) obj;
		if((getLastName().equals(user.getLastName())) 
				&& (getFirstName().equals(user.getFirstName())) 
				&& (getAge()==(user.getAge()))
				&& (getAddress().equals(user.getAddress()))) {
			return true;
		}
		
		return false;
	}

	//accessor of the userNextId
	public static int getUserNextId() {
		return userNextId + 1;
	}
	//mutator of the userNextId
	public static void setUserNextId(int userNextId) {
		User.userNextId = userNextId;
	}
	//accessor of the id
	public int getId() {
		return id;
	}
	//mutator of the Id
	public void setId(int id) {
		this.id = id;
	}
	//accessor of the firstName
	public String getFirstName() {
		return firstName;
	}
	//mutator of the firstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//accessor of the lastName
	public String getLastName() {
		return lastName;
	}
	//mutator of the lastName
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//accessor of the address
	public String getAddress() {
		return address;
	}
	//mutator of the address
	public void setAddress(String address) {
		this.address = address;
	}
	//accessor of the age
	public int getAge() {
		return age;
	}
	//mutator of the age
	public void setAge(int age) {
		this.age = age;
	}

}
