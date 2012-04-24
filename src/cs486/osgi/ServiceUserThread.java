package cs486.osgi;

import java.util.Date;
import java.util.Random;

import cs486.app.MainWindow;
import cs486.osgi.microwave.MicrowaveMockup;

import de.vpe.firstservice.FirstService;

public class ServiceUserThread extends Thread {
	private FirstService service = null;
	private boolean running = true;

	public ServiceUserThread(FirstService service) {
		this.service = service;
	}

	public void run() {
		Date date = null;
		String formattedDate = null;
		
		MainWindow mw = new MainWindow();
		MicrowaveRunner mwr = new MicrowaveRunner();
		mwr.run();
		//mm.main();
		//mw.main();
		
		Random r = new Random();
		int runtime = 60000 * r.nextInt(5); //Runtime is the amount of time the game may be prompted to run, up to five minutes.
		int promptWait = 60000 * 15;
		long begin = System.currentTimeMillis();
		long cur = System.currentTimeMillis();
		
		while (running) {
			if(mwr.getCookTime() >0){	//Prioritize Microwave input
				runtime = mwr.getCookTime();
				
				//Only prompt if game is not in play already
				//System.out.println("Selecting game.  Will allow user to play for "+runtime/60000+" minutes.");
				//System.out.println(cur - begin);
				
				//TODO: Implement game prompt logic
				
				
				
			}else if(cur - begin >= promptWait){ //Wait 15 mins before prompting for a game
				runtime = 60000 * r.nextInt(5);
				begin = System.currentTimeMillis();
				//Only prompt if game is not in play already
			}
			
			cur = System.currentTimeMillis();
			
			
			/*runtime = 60000 * r.nextInt(5);
			
			//Game Prompt logic here.
			date = new Date();
			try {
				formattedDate = this.service.getFormattedDate(date);
			} catch (RuntimeException e) {
				System.out
						.println("RuntimeException occured during service usage: "
								+ e);
			}
			System.out.println("ServiceUserThread: converted date has value: "
					+ formattedDate);
			System.out.println("Selecting game.  Will allow user to play for "+runtime/60000+" minutes.");
			try {
				Thread.sleep(runtime);
			} catch (InterruptedException e) {
				System.out.println("ServiceUserThread ERROR: " + e);
			}*/
		}
	}

	public void stopThread() {
		this.running = false;
	}
}