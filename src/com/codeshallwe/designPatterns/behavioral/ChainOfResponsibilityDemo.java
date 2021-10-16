package com.codeshallwe.designPatterns.behavioral;

/*
 * Let's say we have Earth Object. From there we will send a message to other planets. Jupiter, Saturn and Beyond. If aliens are in those places, am sure they will respond
 * 
 * At this point, Jupiter alone can handle English. So Jupyer responded.
 * 
 * Let's see how we can make this be handled by more than one alien group.
 * 
 * Changed the language of Saturn to english. we shall see if saturn is able to handle the message
 * Message reached 2 planets.
 * 
 * Let's make the language dynamic and see one last case where none of them would be able to handle the msg
 * 
 * no body to handle when we change the language to something they cant handle
 */
public class ChainOfResponsibilityDemo {

	public static void main(String[] args) {
		Earth earth = new Earth();
		earth.sendMessage();
	}
}

class Earth {
	public void sendMessage() {
		// Let's have out implementations here. We also need to set the order here as to
		// which one to handle the message next
		Planet jupiter = new Jupiter();
		Planet saturn = new Saturn();
		Planet beyond = new Beyond();
		// setting successors
		jupiter.setSuccessor(saturn);
		saturn.setSuccessor(beyond);

		// let's initiate the message from Jupiter
		jupiter.handleMessage(new Message("NewLanguage"));
	}
}

abstract class Planet {
	protected Planet successor;

	public void setSuccessor(Planet successor) {
		this.successor = successor;
	}

	// individual planets will handle this one their own style
	public abstract void handleMessage(Message msg);
}

class Beyond extends Planet {
	@Override
	public void handleMessage(Message msg) {
		if ("Symbols".equalsIgnoreCase(msg.getLanguage()))
			System.out.println("Hello from Beyond.. We will come find you");
		// no successors here
	}
}

class Saturn extends Planet {
	@Override
	public void handleMessage(Message msg) {
		if ("english".equalsIgnoreCase(msg.getLanguage()))
			System.out.println("Hello from Saturn.. We will come find you");
		// once this is handled, we still want the message to go to next planet
		this.successor.handleMessage(msg);
	}
}

class Jupiter extends Planet {
	@Override
	public void handleMessage(Message msg) {
		if ("English".equalsIgnoreCase(msg.getLanguage()))
			System.out.println("Hello from Jupyter.. We will come find you");
		// once this is handled, we still want the message to go to next planet
		this.successor.handleMessage(msg);
	}
}

class Message {

	private String language;

	public Message(String language) {
		super();
		this.language = language;
	}

	public String getLanguage() {
		return this.language;
	}

	public String getMessage() {
		return "Hello from somewhere nearby..come find us";
	}
}
