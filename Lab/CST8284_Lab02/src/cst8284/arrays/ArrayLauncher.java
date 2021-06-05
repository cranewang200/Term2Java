package cst8284.arrays;

public class ArrayLauncher {
	public static void main(String[] args) {
		display1DArrayOfPrimitives();
		display2DArrayOfPrimitives();
		display1DArrayOfObjects();
		display2DArrayOfObjects();
	}

	
	public static void display1DArrayOfPrimitives() {
		System.out.println("Loading 1D array of primitives...");

		int[] oneDimensionalArray; // note that array object is null initially
		oneDimensionalArray = new int[] { 10, 20, 30 }; // assign new array object to variable
								  // and load with 10, 20, 30
		System.out.println("*** Finished loading 1D array of primitives***");
		
		System.out.println("1D array contents are ");
		for (int i=0; i<oneDimensionalArray.length; i++)
			System.out.print(oneDimensionalArray[i] + "    ");
	    // TODO: Task 1: Insert a breakpoint in the line above, execute in debug 
		// until you reach that line, and then use 'Step Into' until the array is
		// fully loaded.  Note the integer value stored in the array during each loop by
		// monitoring the contents of the Variables view pane (usually found in the
		// top right corner when debug is running), and the draw the memory map of the 
		// fully-loaded array, according to the instructions provided in the
		// lab 2 document
	}
	
	
	public static void display2DArrayOfPrimitives() {
		System.out.println("\n\nLoading 2D array of primitives...");

		int[][] twoDimensionalArray = new int[][] { { 1, 2, 3, 4 }, { 3, 6, 9, 12 } };
		System.out.println("*** Finished loading 2D array of primitive values ***");
		
		// Output the values
		System.out.print("2D array contents are \n");
		for (int[] row : twoDimensionalArray) {
			for (int column : row)
				System.out.print(column + "    ");
			System.out.println();  // add space after output
		} // TODO: Task 2: Insert a breakpoint at the second (i.e. inner) for() loop
		// in the code above.  Run the code in Debug to that line, and then 'Step Over' 
		// each line until the array is fully loaded with integers, paying attention to 
		// the values stored in row and column in the Variable view pane.  Draw the 
		// memory map of the twoDimensionalArray of primitives according to the 
		// instructions provided in the lab 2 document
	}

	
	public static void display1DArrayOfObjects() {
		System.out.println("\nLoading 1D array of objects...");
		
		Student[] oneDimensionalArrayOfRefs = new Student[5];
		for (int studentNum = 0; studentNum < oneDimensionalArrayOfRefs.length; studentNum++) // gs is each element of the array
			oneDimensionalArrayOfRefs[studentNum] = new Student(studentNum + 11);
		System.out.println("*** Finished loading 1D array of objects ***");
		// TODO: Task 3: Insert a breakpoint in the line above, execute in Debug to that
		// line, and draw the memory map of the oneDimensionalArrayOfRefs containing   
		// three objects, according to the instructions provided in the lab 2 document
		
		System.out.print("1D array contents are \n");
		for (Student s : oneDimensionalArrayOfRefs)
			System.out.print(s.getStudentNumber() + "   ");
	}

	
	public static void display2DArrayOfObjects() {
		System.out.println("\n\nLoading 2D array of objects...");
		Student[][] twoDimensionalArrayOfObjects = new Student[][] { 
			{ new Student("Robin", "Gander", 10), new Student("Vijay", "Singh", 20) },
		    { new Student("Hassan", "Ahmed", 11), new Student("Howard", "Rosenblum", 21) }, 
			{ new Student("Sheila", "Zhang", 12), new Student("Chris", "Obotu", 22) } ,
			{ new Student("Rob", "Sworder", 13), new Student("Bruce", "Lee", 23) } 
		};
		System.out.println("*** Finished loading 2D array of objects ***");
		// TODO: Task 4: Insert a breakpoint in the line above, execute in Debug to 
		// that line, and draw the memory map of the 2DArrayOfObjects containing six
		// Student objects according to the instructions provided in the lab 2 document
	
		//add some print out to demo the question 3
		System.out.println();
		System.out.println("question 3 before excute");
		System.out.println("two dimensional arry [2][1]: "+
				twoDimensionalArrayOfObjects[2][1].getFirstName()+","+
				twoDimensionalArrayOfObjects[2][1].getLastName()+","+
				twoDimensionalArrayOfObjects[2][1].getStudentNumber());
		System.out.println("two dimensional arry [1][0]: "+
				twoDimensionalArrayOfObjects[1][0].getFirstName()+","+
				twoDimensionalArrayOfObjects[1][0].getLastName()+","+
				twoDimensionalArrayOfObjects[1][0].getStudentNumber());
		
		System.out.println();
		twoDimensionalArrayOfObjects[2][1] = twoDimensionalArrayOfObjects[1][0];
		System.out.println("question 3 after excute \ntwo dimensional arry [2][1]: " + 
				twoDimensionalArrayOfObjects[2][1].getFirstName()+","+
				twoDimensionalArrayOfObjects[2][1].getLastName()+","+
				twoDimensionalArrayOfObjects[2][1].getStudentNumber());
		System.out.println("two dimensional arry [1][0]: "+
				twoDimensionalArrayOfObjects[1][0].getFirstName()+","+
				twoDimensionalArrayOfObjects[1][0].getLastName()+","+
				twoDimensionalArrayOfObjects[1][0].getStudentNumber());
		System.out.println();

		System.out.print("2D array contents are \n");
		for (Student[] row : twoDimensionalArrayOfObjects) {
			for (Student element : row) 
				System.out.print("\t" + element.getFirstName() + " " + element.getLastName() +
				"  Student#: " + element.getStudentNumber() + "   ");	
			System.out.println();  
		}

	}
}
