package com.assign7;

import java.util.ArrayList;
import java.util.List;

public class Source {
	public static void main(String[] args) {
		
		TransactionParty t = new TransactionParty("Daniel D'Cruz" , "Giselle Dawn-Wright");
		
		Receipt r = new Receipt(t,"250,10@100,3@50,7" );
		
		GenerateReceipt g = new GenerateReceipt();
		
		
		System.out.println(g.verify(r));  //2
		System.out.println(g.calcGST(r)); //37800
		
	}
}

class TransactionParty{
	
	String seller;
	String buyer;
	
	public TransactionParty(String seller, String buyer) {
		
		this.seller = seller;
		this.buyer = buyer;
		
	}
	
	public TransactionParty() {
		
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

}

class Receipt{
	
	TransactionParty transactionParty;
	String productsQR;
	
	public Receipt(TransactionParty transactionParty, String productsQR){
		this.transactionParty = transactionParty;
		this.productsQR = productsQR;
	}
	public Receipt() {
		
	}

	public String getProductsQR() {
		return productsQR;
	}

	public void setProductsQR(String productsQR) {
		this.productsQR = productsQR;
	}

}

class GenerateReceipt{
	
	int GST;

	public int getGST() {
		return GST;
	}

	public void setGST(int gST) {
		GST = gST;
	}

	@Override
	public String toString() {
		return "GeneratedReceipt [GST = INR." + GST + "/-]";
	}

	public int verify(Receipt r) {
		
		
		//^[A-Za-z][a-zA-Z\s\\'-]+$
		//"[a-zA-Z]+\\s+[a-zA-Z]+\\'\\-[a-zA-Z]+"   //Daniel D'Cruz  //Giselle Dawn-Wright
		
		if(  (r.transactionParty.getBuyer().matches("^[A-Za-z][a-zA-Z\\s\\'\\-]+$")) &&
				(r.transactionParty.getSeller().matches("^[A-Za-z][a-zA-Z\\s\\'\\-]+$"))  ){
			
			return 2;
		}
		else if(  (r.transactionParty.getBuyer().matches("^[A-Za-z][a-zA-Z\\s\\'\\-]+$")) ||
				(r.transactionParty.getSeller().matches("^[A-Za-z][a-zA-Z\\s\\'\\-]+$")) ) {
			
			return 1;
		}
		else {
			return 0;
		}

	}
	
	public String calcGST(Receipt r) {
		
		//String str = "250,10@100,3@50,7";
		
		List<Product> list = new ArrayList<>();  //[200 10]
		
		String str = r.getProductsQR();
		String[] s = str.split("@");
		for(String e : s) {
			String[] s1 = e.split(",");
			
			//System.out.println(s1[0]);
			
			Product p = new Product();
			
			p.setRate(Integer.parseInt(s1[0]));//100X   //  s1->[250,10]
			p.setQuan(Integer.parseInt(s1[1]));//200X
			list.add(p);  
		}
		
		// System.out.println(list); 
		//[Product [rate=250, quan=10], Product [rate=100, quan=3], Product [rate=50, quan=7]]
		
		int gst;
		
		int res=0; // 2500 -> 2800 - > 3150 
		
		for(Product a : list) {
			 res = res + (a.getRate() * a.getQuan());
			 
		}
		
		
		gst= res * 12;
		
		setGST(gst);
		
		//System.out.println(GST);
		
		return toString();
		
		
	}
	
}

class Product{
	int rate;
	int quan;
	
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	
	@Override
	public String toString() {
		return "Product [rate=" + rate + ", quan=" + quan + "]";
	}
	
	
}




