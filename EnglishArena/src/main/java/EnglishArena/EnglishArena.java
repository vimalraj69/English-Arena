package EnglishArena;

import java.util.*;

public class EnglishArena extends Thread {
	private int prepTime;
	private int speakTime;
	private List<String> SpokenNames;
	Names name;
	Random rand;
	Topics topic;
	
	EnglishArena(int prepTime, int speakTime, String namePath, String topicPath) {
		this.prepTime = prepTime;
		this.speakTime = speakTime;
		SpokenNames = new ArrayList<>();
		rand = new Random();
		
		name = new Names(namePath);
		topic = new Topics(topicPath);
	}

	public void run() {
		showTopic();
		prepTime();
		String name = chooseName();
		showName(name);
		speakTime();

	}
	
	private void showTopic() {
		String topicName =topic.getTopic();
		try {
			for (char c : topicName.toCharArray()) {

				System.out.print(Character.toUpperCase(c));
				Thread.sleep(150);

			}
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.print(e);
		}
		System.out.println();
	}
	
	
	private void prepTime() {
		System.out.print("Preparation Time (" + prepTime + ") :");
		for (int i = 0; i < prepTime; i++) {
			try {
				System.out.print(i + 1 + " ");
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println();
	}

	
	private String chooseName() {
		int len = name.getLength();

		while (SpokenNames.size() != len) {
			int index = rand.nextInt(len);
			String nam = name.getName(index);
			if (!SpokenNames.contains(nam)) {
				SpokenNames.add(nam);
				return nam;
			}
		}

		return "";
	}

	
	private void speakTime() {
		System.out.print("Speaking Time (" + speakTime + ") :");
		for (int i = 0; i < speakTime; i++) {
			try {
				System.out.print(i + 1 + " ");
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println();
	}

	
	private void showName(String name) {
		try {
			for (char c : name.toCharArray()) {

				System.out.print(c);
				Thread.sleep(500);

			}
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.print(e);
		}
		System.out.println();
	}
}
