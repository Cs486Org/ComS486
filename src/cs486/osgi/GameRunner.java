package cs486.osgi;

import cs486.app.MainWindow;

public class GameRunner implements Runnable {

	private MainWindow mw;
	@Override
	public void run() {
		if(mw == null){
			mw = new MainWindow();
		}

	}
	
	public void suggestGame(long runtime){
		if(mw != null){
			mw.suggestGame(runtime);
			System.out.println("Playing game: "+runtime/60000+" minutes");
		}
	}
	
	public boolean isGameInPlay(){
		if(mw != null){
			return mw.isGameInPlay();
		}
		return true;
	}

}
