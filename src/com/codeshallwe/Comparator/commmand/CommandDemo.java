package com.codeshallwe.Comparator.commmand;

/*
 * Say, you have this helper Robot Dinosaur that does stuff for you. You just need to tell the Dino what needs to be done. It will be done. Let's play Talking Dino
 * 
 * Let's try telling Dino to go fetch a ball. Only this time, we want the Dino to recognize the command and do in order to not repeat what we did for Talking Dino. Let's go tweak the Dino. Open closed principle would say, don't! But let's give it a try.
 * 
 *  Now, say you want the Robot to do few more things for you. But this time listening to Open Closed principle, let's try to find if we can decouple the Dino and the actions. This would help us with add new actions without bothering to tweak the Robot every time.
 *  
 *  We should also be able to pass on the objects as well at times. Say when you play go fetch, fetch what? We should be able to do that as well in decoupled way.
 *  
 *  One additional thought behind Command pattern is to saving the requests in a lists.
 */
public class CommandDemo {

	public static void main(String[] args) {
		Dino dinoObj = new Dino();
		dinoObj.execute("Repeat what I say", "repeat");
		dinoObj.execute("Go fetch", "fetch");

		// Let's try Repeat first
		RoboDino rb = new RoboDino();
		Stuff repeat = new Repeat();
		rb.execute(repeat);
		Ball ball = new Ball();
		Stuff goFetch = new GoFetch(ball);
		rb.execute(goFetch);
	}
}
//This would be the command type. All the commands will in turn use it. 
interface Stuff {
	void doIt();
}

class GoFetch implements Stuff {

	private Ball ball;

	public GoFetch(Ball ball) {
		this.ball = ball;
	}
	@Override
	public void doIt() {
		System.out.println("Fetching " + this.ball);
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

class Repeat implements Stuff {

	@Override
	public void doIt() {
		System.out.println("Repeating");
	}
}

class RoboDino {
	public RoboDino() {
	}

	public void execute(Stuff stuff) {
		stuff.doIt();
	}
}

class Dino {
	public Dino() {
	}
	public void execute(String s, String cmd) {
		switch (cmd) {
			case "repeat" :
				System.out.println(s);
				break;
			case "fetch" :
				System.out.println("Fetching");
		}
	}

}

/*
 * the remote should know how to interpret button presses and make requests, but
 * it shouldn’t know a lot about home automation or how to turn on a hot tub.
 * 
 * Whenever a new vendor class comes out, we’d have to go in and modify the
 * code, potentially creating bugs and more work for ourselves!
 * 
 * 
 */
