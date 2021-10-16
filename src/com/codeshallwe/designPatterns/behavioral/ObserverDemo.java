package com.codeshallwe.designPatterns.behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Going by SOLID principles, let's have a couple of interfaces ready for publishers and subscribers
 * 
 * Since you unsubscribed, you did not receive the second newsletter.
 * 
 * Let's try to tweak this little bit.
 * It would be nice to know which newsletter that we are recieving. Say Newsletter 1,2
 * 
 * Also, Is there a way to not unsubscribe but just turn off? Some newsletters allow us to have our preference. Let's try that.
 * 
 * Instead of having iSubscriber as an interface, we can also create it as an Abstract Class. 
 * 
 * With this we are able to update our preference with a flag.
 */
public class ObserverDemo {

	public static void main(String[] args) {
		iPublisher pub = new CompanyZ();
		iSubscriber you = new You(1); // each get an id
		iSubscriber yourFriend = new YourFriend(2);
		pub.subscribe(you);
		pub.subscribe(yourFriend);
		// Before that let's do the Newsletter
		pub.sendNewsLetter("Newsletter 1");
		// We don't want this step. instead turning off the setting
		// pub.unsubscribe(you);// you unsubscribe
		pub.updateSetting(you, false);// this way, tryin to update for the user,
										// with the flag
		pub.sendNewsLetter("Newsletter 2");// you will not receive this
											// newsletter
	}
}

interface iPublisher {
	void subscribe(iSubscriber sub);
	void unsubscribe(iSubscriber sub);
	void sendNewsLetter(String news);
	void updateSetting(iSubscriber sub, boolean flag);
}

interface iSubscriber {
	void update(iPublisher pub, String news);
	int getId();
	boolean isPreference();
	void setPreference(boolean preference);
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
	public void sendNewsLetter(String news) {
		// here when sending the newsletter, we need to make sure the flag is
		// true.
		if (null != newsletterList)
			newsletterList.stream().filter(iSubscriber::isPreference)
					.forEach(sub -> {
						sub.update(this, news);
					});
	}

	@Override
	public void updateSetting(iSubscriber sub, boolean flag) {
		// Here we update the flag
		if (null != newsletterList) {
			Optional<iSubscriber> subscriber = newsletterList.stream()
					.filter(subs -> sub.getId() == subs.getId()).findFirst();
			subscriber.ifPresent(subs -> {
				subs.setPreference(flag); // updates the preference
			});
		}
	}
}

// Let's have concrete implementations for subscribers
// We also need the subscribers to have the flag.
class You implements iSubscriber {

	private int id;

	private boolean preference;

	protected You(int id) {
		super();
		this.id = id;
		// this on initializing is always true. Later you can update the setting
		this.preference = true;
	}
	@Override
	public void update(iPublisher pub, String news) {
		System.out.println("You got the :: " + news);
	}
	@Override
	public int getId() {
		return this.id;
	}
	public boolean isPreference() {
		return preference;
	}
	public void setPreference(boolean preference) {
		this.preference = preference;
	}
}

class YourFriend implements iSubscriber {

	private int id;

	private boolean preference;

	protected YourFriend(int id) {
		super();
		this.id = id;
		// this on initializing is always true. Later you can update the setting
		this.preference = true;
	}
	@Override
	public void update(iPublisher pub, String news) {
		System.out.println("YourFriend got the :: " + news);
	}
	@Override
	public int getId() {
		return this.id;
	}
	public boolean isPreference() {
		return preference;
	}
	public void setPreference(boolean preference) {
		this.preference = preference;
	}
}
