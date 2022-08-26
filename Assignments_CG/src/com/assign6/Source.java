package com.assign6;

import java.util.*;

public class Source {
	public static void main(String[] args) {
		
		EmailOperations e = new EmailOperations();
		Header h = new Header("PQR@gmail.com", "abc@gamil.com");
		Email e1 = new Email(h,"Hi There Hows you","Regards");
		
		System.out.println(e.emailVerify(e1)); //2
		System.out.println(e.bodyEncryption(e1)); //Kl Wkhuh Krzv brx
		System.out.println(e.greetingMessage(e1)); // Regards atharva
	}
}

class Header {
	
	String from;
	String to;
	
	
	public Header(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}
	
	
}


class Email {
	
	Header header;
	String body;
	String greeting;
	
	
	public Email(Header header, String body, String greeting) {
		this.header = header;
		this.body = body;
		this.greeting = greeting;
	}
	
	public Email() {
		
	}


	public Header getHeader() {
		return header;
	}


	public void setHeader(Header header) {
		this.header = header;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getGreeting() {
		return greeting;
	}


	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	
}

class EmailOperations {
	
	//public static final String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public int emailVerify(Email e) {
		
		
		
		if (  (e.header.getTo().matches("[a-zA-Z_]+@[a-zA-Z]+\\.[a-zA-Z]+")) && 
			(e.header.getFrom().matches("[a-zA-Z_]+@[a-zA-Z]+\\.[a-zA-Z]+")) ){
			
			return 2;
		}
		
		else if (  (e.header.getTo().matches("[a-zA-Z_]+@[a-zA-Z]+\\.[a-zA-Z]+")) || 
				(e.header.getFrom().matches("[a-zA-Z_]+@[a-zA-Z]+\\.[a-zA-Z]+"))  ) {
			
			return 1;
		}
		
		else {
			return 0;
		}		
				// "[a-zA-Z_]+\\@[a-zA-Z]+\\.[a-zA-Z]+"
		
	}
	
	public String bodyEncryption(Email e) {  //"abcdefghijklmnopqrstuvwxyz"
		
		String s =  e.getBody();
		String cipher = "";
		
		for(int i = 0 ; i < s.length(); i++) {
			//Hi There Hows you
			int c = s.charAt(i);
			
			//System.out.println(s.charAt(i)); 
			
			if(s.charAt(i) == ' ' ) {
				cipher  = cipher + ' ';
				continue;
			}
			
			else {
				if(Character.isUpperCase(s.charAt(i))) {
					
					c = c + (3 % 26);
	                if (c > 'Z') { 
	                    c = c - 26;
	                }
				}
				else if(Character.isLowerCase(s.charAt(i))){
					 c = c + (3 % 26);
	                    if (c > 'z') { 
	                        c = c - 26;
	                    }
				}
	           cipher = cipher + (char) c;
			}
	}
	//System.out.println(cipher);
	return cipher;
}
		

	public String greetingMessage(Email e) {
		
		String r= e.getGreeting();
		String a = e.header.getFrom();
		// System.out.println(a);
		
		
		
		
		String[] str = a.split("@");

		
		// System.out.println(str[0]);
		// System.out.println(r);
		
		String s =  r.concat(" "+ str[0]);
		// System.out.println(s);
		return s;
	}
}



