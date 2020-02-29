package designpattern.dip;

public class Notification {
	private MessagerSender messagerSender;


	public Notification(MessagerSender messagerSender) {
		this.messagerSender = messagerSender;
	}

	public void sendMessage(String cellphone, String message) {
		this.messagerSender.send(cellphone, message);
	}
}
