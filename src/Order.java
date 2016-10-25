import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Order extends Observable {
	
	private ArrayList<Observer> observers;
    String availability;  
    ArrayList<MenuModel> order;
    
    public ArrayList<MenuModel> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<MenuModel> order) {
		this.order = order;
	}

	public Order() {
    	observers = new ArrayList<Observer>();
    	order = new ArrayList<MenuModel>();
    }
    
    public String getAvailability() {  
        return availability;  
    }  



	public void notifyObservers(Observable observable, MenuModel item) {
         for (Observer ob : observers) {  
             ob.update(this, item);  
      }  
  
    }  
  
    public void registerObserver(Observer orderDetails) {  
         observers.add(orderDetails);
          
    }  
  
    public void removeObserver(Observer observer) {  
         observers.remove(observer);  
          
    }
    
    public void changeData(MenuModel item) {
    	order.add(item);
    	setChanged();
    	notifyObservers(this, item);
    }
    
    public void clearOrder() {
    	order.clear();
    	changeData(new MenuModel("clear", 0.00));
    }
}
