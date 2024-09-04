package web.pageObjects.startgy;

import java.util.Map;

public class CreditCard implements paymentOption{
	
	
	
	
	String CardNumber="789456123";
	String CVV="154";
	String YOE="11/24";
	

	@Override
	public void entryPaymentInfo(Map<String, String> paymentDetalies) {
		System.out.println(CardNumber);
		System.out.println(CVV);
		System.out.println(YOE);
		
		
		paymentDetalies.get("CVV");
		
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println();
	}

}
