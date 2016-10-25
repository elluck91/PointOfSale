import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

class McPatternsPresenter {
    //This is the class that will handle the model <-> UI communication.
    MenuModel model;
    McPatternsGUI view;
    private ArrayList<MenuModel> menuList;
    
    void loadMenuItems() {
        File file = new File("menu");
        FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String menuItem;
			String[] item;
			menuList = new ArrayList<MenuModel>();
					
			while ((menuItem = br.readLine()) != null) {
				item = menuItem.split("\\|");
				menuList.add(new MenuModel(item[0], Double.parseDouble(item[1])));
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
    
    public int getNum() {
    	return menuList.size();
    }

    void attachView(McPatternsGUI view) {
        this.view = view;
    }
    
    public ArrayList<MenuModel> getItems() {
    	
    	return menuList;
    }

	public ArrayList<MenuModel> getButtons() {
		//generate buttons and return them
		
		ArrayList<MenuModel> buttons = new ArrayList<MenuModel>();
		
		for (int i = 0; i < menuList.size(); i++) {
			MenuModel button = new MenuModel(menuList.get(i).getItemName(), menuList.get(i).getItemPrice());
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					view.observable.changeData(button);
				}
				
			});
			buttons.add(button);
		}
		
		return buttons;
	}
}