package com.codeshallwe.Comparator.test;

import java.util.ArrayList;
import java.util.List;

/*
 * Going by SOLID principles, let's have a couple of interfaces ready for publishers and subscribers
 * 
 * Since you unsubscribed, you did not receive the second newsletter.
 * 
 */
public class ObserverDemo {

	public static void main(String[] args) {
		iPublisher pub = new CompanyZ();
		iSubscriber you = new You(1); // each get an id
		iSubscriber yourFriend = new YourFriend(2);
		pub.subscribe(you);
		pub.subscribe(yourFriend);
		pub.sendNewsLetter();
		pub.unsubscribe(you);// you unsubscribe
		pub.sendNewsLetter();// you will not receive this newsletter
	}
}

interface iPublisher {
	void subscribe(iSubscriber sub);
	void unsubscribe(iSubscriber sub);
	void sendNewsLetter();
}

interface iSubscriber {
	void update(iPublisher pub);
	int getId();
}

// Let's have a concrete implementation of Publisher now.
/*
 * Publisher should be maintaining a list of subscribers from where they can be
 * removed or the news ones be added.
 */
class CompanyZ implements iPublisher {

	// The list
	List<iSubscriber> newsletterList;

	@Override
	public void subscribe(iSubscriber sub) {
		System.out.println("Adding subscriber with Id :: " + sub.getId());
		if (null == newsletterList || newsletterList.isEmpty())
			newsletterList = new ArrayList<>();
		newsletterList.add(sub);
		System.out.println("Number of subscribers :: " + newsletterList.size());
	}

	@Override
	public void unsubscribe(iSubscriber sub) {
		System.out.println("Removing Subscriber with Id :: " + sub.getId());
		if (null != newsletterList || !newsletterList.isEmpty())
			newsletterList.removeIf(subs -> sub.getId() == subs.getId());
	}

	@Override
	public void sendNewsLetter() {
		if (null != newsletterList)
			newsletterList.forEach(sub -> {
				sub.update(this); // if you are subscribed to more than one
									// publisher of same type, this will help
			});
	}
}

// Let's have concrete implementations for subscribers
class You implements iSubscriber {

	private int id;

	protected You(int id) {
		super();
		this.id = id;
	}
	@Override
	public void update(iPublisher pub) {
		System.out.println("You got the Newsletter");
	}
	@Override
	public int getId() {
		return this.id;
	}
}

class YourFriend implements iSubscriber {

	private int id;

	protected YourFriend(int id) {
		super();
		this.id = id;
	}
	@Override
	public void update(iPublisher pub) {
		System.out.println("YourFriend got the Newsletter");
	}
	@Override
	public int getId() {
		return this.id;
	}
}
