package cs486.osgi.microwave;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class MicrowaveThread extends Thread {

	private boolean running = false;
	private int runtime = 0;

	public MicrowaveThread(int time) {
		running = true;
		runtime = time;
	}

	private final Set<ThreadCompleteListener> listeners = new CopyOnWriteArraySet<ThreadCompleteListener>();

	public final void addListener(final ThreadCompleteListener listener) {
		listeners.add(listener);
	}

	public final void removeListener(final ThreadCompleteListener listener) {
		listeners.remove(listener);
	}

	private final void notifyListeners() {
		for (ThreadCompleteListener listener : listeners) {
			listener.notifyOfThreadComplete(this);
		}
	}

	public void run() {
	    try {
	      doRun();
	    } finally {
	      notifyListeners();
	    }
	  }

	
	public void doRun() {
		long start = System.currentTimeMillis();
		long cur = System.currentTimeMillis();
		while (running) {
			if (cur - start >= runtime) {
				running = false;
			}
			cur = System.currentTimeMillis();
			
		}

	}
}
