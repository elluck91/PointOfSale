import java.math.BigInteger;

public class CreditCardFactory {
	
	 	public CreditCard getCard(String cardType, BigInteger cardNum) {
	 		CreditCard cc = null;
	 		
	 		if (cardType.equals("MasterCard")) {
	 			cc = new MasterCard(cardType, cardNum);
	 		}
	 		else if (cardType.equals("Visa")) {
	 			cc = new Visa(cardType, cardNum);

	 		}
	 		else if (cardType.equals("AmericanExpress")) {
	 			cc = new AmericanExpress(cardType, cardNum);

	 		}
	 		else if (cardType.equals("Discover")) {
	 			cc = new Discover(cardType, cardNum);

	 		}
	 		
	 		return cc;
		
	}
}
