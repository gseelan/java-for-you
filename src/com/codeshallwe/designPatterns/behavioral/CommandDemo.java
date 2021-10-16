package com.codeshallwe.designPatterns.behavioral;

/*
 * Let's start by implementing a simple Dino class
 * 
 * This will do for Talking Dino. Let's try to add GoFetch to the Dino. With adding one more, the Dino should be able to figure out which command/ stuff is coming to it.
 * 
 * To tell the Dino to fetch what is additional Complexity. Would mean, more params into Dino. We have already violated the Open closed principle by modifying the same class again. Imagine having 100 additional stuff like this.
 * 
 * We will use the SOLID principles to try and solve it. Our main focus is that we should be able to add stuff wihtout violating Open closed principle. Also decouple the Dino from the actions. unlike the switch case we have now in Dino, we want the Dino to just execute stuff regardless of what it gets.
 * 
 * This way, any further Command/Stuff should be added without modifying the Dino class. Further, the main purpose of Command Pattern, encapsulating the invocation, request is happening. The Command/ Stuff in our case is the encapsulation.
 * 
 */
public class CommandDemo {

	public static void main(String[] args) {
		Dino dino = new Dino();
		// Encapsulate the request first
		Stuff repeat = new Repeat("This is repeating");
		dino.doStuff(repeat);

		// Quickly do for Gofetch by passing a Ball
		Ball ball = new Ball();
		Stuff goFetch = new GoFetch(ball);
		dino.doStuff(goFetch);
	}
}

class Ball {
	public Ball() {
	}
	@Override
	public String toString() {
		return "The Ball";
	}
}

// Let's have an interface for Command/ Stuff
interface Stuff {
	void doStuff();
}

class GoFetch implements Stuff {
	private Ball ball; // This is still bit tight on coupling. But check SoLID
						// principles to know how to fix this
	public GoFetch(Ball ball) {
		this.ball = ball;
	}
	@Override
	public void doStuff() {
		System.out.println("Fetching .. " + ball);
	}
}

// Implement the Repeat
class Repeat implements Stuff {

	private String whatToRepeat;
	// With this, we can pass something and ask the Dino to Repeat it.
	public Repeat(String toRepeat) {
		this.whatToRepeat = toRepeat;
	}
	@Override
	public void doStuff() {
		System.out.println(this.whatToRepeat);
	}
}

class Dino {
	// Dino should be able to just do the Stuff/ execute the command.
	public void doStuff(Stuff stuff) {
		stuff.doStuff();
	}
}
