package cs486.osgi;

import java.util.Date;
import java.util.Random;

import cs486.app.MainWindow;

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
		mw.main();
		
		Random r = new Random();
		int runtime = 60000 * r.nextInt(5); //Runtime is the amount of time the game may be prompted to run, up to five minutes.
		try {
			this.sleep(runtime);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  //Initial wait no sense in starting up immediately.  TODO: May extend this to a longer initial wait.
		while (running) {
			runtime = 60000 * r.nextInt(5);
			
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
			}
		}
	}

	public void stopThread() {
		this.running = false;
	}
}