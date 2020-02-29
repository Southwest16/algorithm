package designpattern.ocp.example2;

import designpattern.ocp.example1.Notification;

public class Demo {
	private MessageQueue msgQueue; //基于接口而非实现编程

	//依赖注入
	public Demo(MessageQueue msgQueue) {
		this.msgQueue = msgQueue;
	}

	//msgFromatter: 多态、依赖注入
	public void sendNotification(Notification notification, MessageFromatter msgFromatter) {

	}
}
