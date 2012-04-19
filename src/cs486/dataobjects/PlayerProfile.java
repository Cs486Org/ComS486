package cs486.dataobjects;

public class PlayerProfile {

	private int[] highscores = {0, 0, 0};
	private String name;
	private String catchphrase;
	
	public PlayerProfile() {
		name = "Newbie";
		catchphrase = "NYAN";
	}
	
	public PlayerProfile(String n) {
		name = n;
		catchphrase = "NYAN";
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
}
