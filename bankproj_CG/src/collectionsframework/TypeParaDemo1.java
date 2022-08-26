package collectionsframework;

public class TypeParaDemo1 {
	public static void main(String[] args) {
		
		X x = new X();
		
		Integer[] i = new Integer[] {4, 5, 1, 3, 2};
		Float[] f = new Float[] {1F, 2F, 3F};
		String[] str = new String[] {"Harry", "Ron"};
		
		x.display(i);
		x.display(f);
		x.display(str);
		
		/*
		 * Type Parameter <T> does not work with primitive data types.
		 * Hence int[] i = new int[]{}; won't work.
		 * We have to use class arrays so that JVM duing runtime, can attach this class directly to <T>.
		 *  Integer[] i = new Integer[]{}  -----CORRECT METHOD
		 */
	}
}

class X{
	<T> void display(T[] t) {
		for(T temp : t) {
			System.out.print(temp + " ");
		}
		
		System.out.println();
	}
	
}
