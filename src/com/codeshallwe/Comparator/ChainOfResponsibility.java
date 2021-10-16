package com.codeshallwe.Comparator;

/*
 * 1. We need a someone, a client to send a request
 */
public class ChainOfResponsibility {

	public static void main(String[] args) {
		Earth earth = new Earth();
		earth.sendMessage();
	}
}

/*
 * From here we will send a message to say Jupiter, Saturn and Beyond. If aliens
 * in those planets could udnerstand, they will handle the message. That is the
 * plan
 */
class Earth {
	public void sendMessage() {
		Planet jupy = new Jupiter();
		Planet saturn = new Saturn();
		Planet beyond = new Beyond();
		jupy.setSuccessor(saturn);
		saturn.setSuccessor(beyond);
		jupy.handleMessage(new Message());
	}
}

//planet type
abstract class Planet {
	protected Planet successor;

	public void setSuccessor(Planet successor) {
		this.successor = successor;
	}

	public abstract void handleMessage(Message msg);
}

class Jupiter extends Planet {
	@Override
	public void handleMessage(Message msg) {
		if ("english".equalsIgnoreCase(msg.getLanguage())) {
			System.out.println("Howdy from Jupyter, we are going to find you !");
		}
	}
}

class Saturn extends Planet {
	@Override
	public void handleMessage(Message msg) {
		if ("satlish".equalsIgnoreCase(msg.getLanguage())) {
			System.out.println("Kia Ora from Saturn, we are going to find you !");
		}
	}
}

class Beyond extends Planet {
	@Override
	public void handleMessage(Message msg) {
		if ("English".equalsIgnoreCase(msg.getLanguage())) {
			System.out.println("Vanakkam from Beyond, we are going to find you !");
		}
	}
}

class Message {

	public String getLanguage() {
		return "English";
	}

	public String getMessage() {
		return "Hello People, Welcome to.. come find us";
	}
}
