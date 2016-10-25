user: 010851646 (Juraszek, Lukasz)

1. I used two Design Patterns: Observer and Factory

- The first one - Observer: I used it to manipulate dynamically the Order List and Order Price. First, I created an object Order to be obeservable. Each time I would add a menu item to the order, the current order list and total price would be notified about the change and automatically updated.

Pros: 
Allows you to send data to many other objects in a very efficient manner.
No subject modification is needed to add new observers.
You can add and remove observers at anytime.
Very flexible
Resilient

Cons:
Sending a message has a cost implied by number of observers
Observers are expected to react to messages, but we don't know how they might react.


- The second pattern that I used is the Factory. In particular, I created a Credit Card Factory. It takes cardType as parameter and based off of this information it creates desired type of Credit Card.

Pros:
Allows you to change the design of your application more rapidly - loose coupling
Abstraction
Polymorphism

Cons:
Makes code more difficult to read

