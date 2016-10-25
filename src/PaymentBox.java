import java.math.BigInteger;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PaymentBox extends JFrame {
	public PaymentBox(ArrayList<Order> orderHistory, Order currentOrder) {
		JFrame frame = new JFrame("Payment System");


		String cardNum = JOptionPane.showInputDialog(frame, "Type your credit card number:");

		while (cardNum != null && valid(cardNum).equals("invalid")) {
			cardNum = JOptionPane.showInputDialog(frame, "Type your credit card number:");
		}

		if (cardNum != null && !valid(cardNum).equals("invalid")) {
			CreditCardFactory ccf = new CreditCardFactory();
			CreditCard  cc = ccf.getCard(valid(cardNum), new BigInteger(cardNum));
			JOptionPane.showMessageDialog(null, "Your order has been complete!");
			orderHistory.add(currentOrder);

			for (int i = 0; i < currentOrder.getOrder().size(); i++) {
				System.out.println(currentOrder.getOrder().get(i).getItemName());
			}
			currentOrder.clearOrder();
		}

	}

	public String valid(String cardNum) {
		String cardType = null;

		if (cardNum.length() != 13 && cardNum.length() != 15
				&& cardNum.length() != 16)
			cardType = "invalid";
		else if (cardNum.substring(0, 1).equals("5") && cardNum.length() == 16
				&& Integer.parseInt(String.valueOf(cardNum.charAt(1))) > 0
				&& Integer.parseInt(String.valueOf(cardNum.charAt(1))) <= 5)
			cardType = "MasterCard";
		else if (cardNum.substring(0, 1).equals("4") && (cardNum.length() == 16
				|| cardNum.length() == 13))
			cardType = "Visa";
		else if (cardNum.substring(0, 1).equals("3")
				&& (cardNum.substring(1, 2).equals("4")
						|| cardNum.substring(1, 2).equals("7"))
				&& cardNum.length() == 15)
			cardType = "AmericanExpress";
		else if (cardNum.substring(0, 4).equals("6011")
				&& cardNum.length() == 16)
			cardType = "Discover";

		return cardType;
	}
}
