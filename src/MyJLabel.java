import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class MyJLabel extends JLabel implements Observer {
	private double currentPrice = 0.00;
	DecimalFormat df;
	public MyJLabel() {
		super("Order price: $0.00");
		df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
	}
	public void update(Observable o, MenuModel arg) {
		
		if (arg.getItemPrice() == 0.00) {
			currentPrice = 0.00;
			this.setText("Order price: $" + currentPrice);
		}
		else {
			currentPrice += arg.getItemPrice();
			currentPrice = Double.parseDouble(df.format(currentPrice));
			this.setText("Order price: $" + currentPrice);
		}
		
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		update(arg0, (MenuModel) arg1);
		
	}

}
