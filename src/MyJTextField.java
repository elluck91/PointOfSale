import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class MyJTextField extends JTextField implements Observer{
	
	@Override
	public void update(Observable arg0, Object arg1) {
		double temp = Double.parseDouble(this.getText());
		double temp2 = Double.parseDouble(arg1.toString());
		double result = temp + temp2;
		this.setText(String.valueOf(result));
		
	}

}
