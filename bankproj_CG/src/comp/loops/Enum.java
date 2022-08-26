package comp.loops;


/*
 * Enumerated types : enum
 */

enum College{
	ABC, PQR, XYZ;
}

public class Enum {
	public static void main(String[] args) {
		College col = College.ABC;
		System.out.println(col);
		
		System.out.println("\n**********\n");
		
		String colVal = College.XYZ.toString();
		System.out.println(colVal);
		
		System.out.println("\n**********\n");
		String str = "PQR"; 
		
		College c = College.valueOf(str);
		System.out.println(c);
	
	/*
	 * NOTE : If JVM could not convert string to enum,
	 *  it will throw InvalidArgumentException.
	 */
	
	
	}
}
