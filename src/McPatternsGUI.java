import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class McPatternsGUI extends JFrame {
	McPatternsPresenter presenter;
	CurrentOrder currentOrder;
	Order observable;
	ArrayList<Order> orderHistory;

	public McPatternsGUI(McPatternsPresenter presenter) {

		this.presenter = presenter;
		presenter.attachView(this);
		showGUI();

	}

	private void showGUI() {
		presenter.loadMenuItems();
		observable = new Order();
		orderHistory = new ArrayList<Order>();

		JFrame theFrame = new JFrame("Point of Sale");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());
		theFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 


		JPanel title = new JPanel(new FlowLayout());
		title.add(new JLabel("Welcome to McPatterns"));

		JPanel orderPane = new JPanel();
		orderPane.setLayout(new BoxLayout(orderPane, BoxLayout.PAGE_AXIS));
		orderPane.setPreferredSize(new Dimension(250, 0));
		JLabel orderDetails = new JLabel("Your order");
		MyJLabel price = new MyJLabel();
		price.setAlignmentY(CENTER_ALIGNMENT);

		orderPane.setBorder(BorderFactory.createRaisedBevelBorder());
		orderPane.add(orderDetails);



		JPanel buttonPanel = new JPanel();

		int rows = 	(int) Math.ceil(presenter.getNum() / 3.0);
		buttonPanel.setLayout(new GridLayout(0, 3));



		ArrayList<MenuModel> buttons = presenter.getButtons();

		currentOrder = new CurrentOrder("");
		observable.registerObserver(currentOrder);
		observable.registerObserver(price);

		for (int i = 0; i < buttons.size(); i++) {
			buttonPanel.add(buttons.get(i));
		}




		JButton confirm = new JButton("Place Order");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentBox box = new PaymentBox(orderHistory, observable);


			}

		});

		JButton cancel = new JButton("Cancel Order");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observable.clearOrder();
			}

		});

		orderPane.add(currentOrder);
		orderPane.add(price);
		orderPane.add(confirm);
		orderPane.add(cancel);




		theFrame.add(title,BorderLayout.NORTH);
		theFrame.add(buttonPanel, BorderLayout.CENTER);
		theFrame.add(orderPane, BorderLayout.EAST);
		theFrame.setSize(800,600);

		theFrame.pack();
		theFrame.setVisible(true);

	}
}
