package cs486.osgi;

import cs486.osgi.microwave.MicrowaveMockup;

public class MicrowaveRunner implements Runnable {

	private MicrowaveMockup mm;
	@Override
	public void run() {
		if(mm == null){
			mm = new MicrowaveMockup();
		}
	}
	
	public int getCookTime(){
		if(mm != null){
			return mm.getCookingTime();
		}
		else{
			return -1;
		}
	}

}
