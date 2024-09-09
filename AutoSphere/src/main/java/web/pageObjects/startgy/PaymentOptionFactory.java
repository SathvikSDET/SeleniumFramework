package web.pageObjects.startgy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {
	
	
	private static final Supplier<PaymentModeOptions> CHEQUE = () -> new Cheque();
	private static final Supplier<PaymentModeOptions> PAYPAL= () -> new PayPal();
	private static final Supplier<PaymentModeOptions> BANKTRANSFER = () -> new BankTransfer();
	private static final Map<String, Supplier<PaymentModeOptions>> MAP = new HashMap<String, Supplier<PaymentModeOptions>>();
	
	
	static {
		MAP.put("cheque", CHEQUE);
		MAP.put("paypal", CHEQUE);
		MAP.put("banktrasfer", CHEQUE);
	}
	
	public static PaymentModeOptions get(String option) {
		return MAP.get(option.toLowerCase()).get();
	}
	
	

}
