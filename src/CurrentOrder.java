import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

public class CurrentOrder extends JTextArea implements Observer {
	
	public CurrentOrder(String name) {
		super(name);
	}
	

	public void update(Observable o, MenuModel item) {
		
		if (item.getItemName().equals("clear")) {
			this.setText("");
		}
		else {
			String s = this.getText();
			this.setText(s + "\n" + item.getItemName());
		}
		
		
	}


	@Override
	public void update(Observable o, Object arg) {
		update(o, (MenuModel)arg);
		
	}

}
