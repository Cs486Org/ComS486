package cs486.dataobjects;

import java.util.ArrayList;

public class PlayerProfile {

	private int[] highscores = {0, 0, 0};
	private String name;
	private String catchphrase;
	private ArrayList<PlayerProfile> friends = new ArrayList<PlayerProfile>();
	
	public PlayerProfile() {
		name = "Newbie";
		catchphrase = "I'm new here.";
	}
	
	public PlayerProfile(String n) {
		name = n;
		catchphrase = "I'm new here.";
	}
	
	public PlayerProfile(String n, String c) {
		name = n;
		catchphrase = c;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCatchphrase() {
		return catchphrase;
	}
	
	public String toString() {
		return name + ": " + catchphrase;
	}
	
	public int[] getHighScores() {
		return highscores;
	}
	
	public int getHighScore(int i) {
		return highscores[i];
	}
	
	public ArrayList<PlayerProfile> getFriendsList() {
		return friends;
	}
	
	public PlayerProfile[] getFriendsArray() {
		return (PlayerProfile[]) friends.toArray();
	}
	
	public boolean addFriend(PlayerProfile pp) {
		return friends.add(pp);
	}
	
	public boolean removeFriend(PlayerProfile pp) {
		return friends.remove(pp);
	}
}
