package cs486.games;

public interface BFPlayable {

	/**
	 * Begin execution of the game.
	 */
	public void play();
	
	/**
	 * Pause execution of the game.  Possibly display a 'PAUSED' screen.
	 */
	public void pause();
	
	/**
	 * Resume execution from a paused state.
	 */
	public void resume();
	
	/**
	 * After a round of the game has completed, report the final score to the game manager.
	 */
	public void reportScore();
}
