package main.java.bank.services;

import main.java.cs525.mum.services.Message;
import main.java.cs525.mum.services.Notification;

public class NotificationMail implements Notification {
	
	@Override
	public void send(Message notification) {
		System.out.println("-------Notification Message Sended--------");
		System.out.println(notification.toString());
	}

}
