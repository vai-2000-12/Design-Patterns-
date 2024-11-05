/*
Problem: Design a Notification System
Imagine a scenario where we want to send notifications to users. We want our system to be flexible so that, in the future, we could add new types of notifications (like email, SMS, or push notifications) without changing existing code.

Requirements:
1.The system should support sending notifications via different channels, like Email and SMS.

2. It should be easy to add more channels in the future without modifying existing code.
*/

// Code for the This Notification System :-
interface Notification{
    void send(String message);
}
class SMSNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("Sending through : " + message);
    }
}

class EmailNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("Sended through : " + message);
    }
}

class NotificationSender {
   private Notification notify;
  
   public NotificationSender(Notification notify){
     this.notify = notify;
   }
   
   
   public void setNotification(Notification notify){
   this.notify = notify;
   }
    
   public void setNotification(String message){
    notify.send(message);
   }
}

class A{
    public static void main(String[] args) {
        NotificationSender sender = new NotificationSender(new EmailNotification());
        sender.setNotification("Via Email");

        NotificationSender sender1 = new NotificationSender(new SMSNotification());
        sender1.setNotification("Via SMS");

    }
}
// Stratergy Pattern Used Here to Design this System : 
// Any Other Channel Can make use of the interface Notification to send any message