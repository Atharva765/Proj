package com.exception;

public class Exception4 {
	public static void main(String[] args) {
		D d = new D();
		try{
			float f = 3.5f;    //scope of f will only be in this particular block.
			d.m1();
		}
		catch(NullPointerException npe) {
			System.out.println("String cannot be NULL!!");
		}
		finally {
			d = null;
		}
	}
}

class D{
	public void m1() {
		
		String str = null;
		System.out.println(str.length());
		
	}
}



/*
 * Type 1:  WORKS
     
     try{
     
     }
     catch(){
     
     }
     
  *Type 2: WORKS
      
     try{
     
     }
     finally{
     
     }
     
     
  *Type 3:  WORKS
    
       try{
       
       }
       catch(){
       
       }
       finally{
       
       }
 
    *Type 4:  NOT WORKS //CF
       
       try{
       
       }
       sysout()  : CF  -> Catch/finally block should immediately come after try block else it will if CF.
       catch(){
       
        }
       
*/
