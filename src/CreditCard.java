import java.math.BigInteger;

public abstract class CreditCard {
	
	private String cardType;
	private BigInteger cardNum;
	
	public BigInteger getCardNum() {
		return cardNum;
	}

	public void setCardNum(BigInteger cardNum) {
		this.cardNum = cardNum;
	}

	public CreditCard(String cardType, BigInteger bigInteger) {
		this.setCardType(cardType);
		this.cardNum = bigInteger;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
