package de.vpe.simplebundle.impl;

public class HelloWorldThread extends Thread {
	private boolean running = true;

	public HelloWorldThread() {
	}

	public void run() {
		while (running) {
			System.out.println("Hello World!");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("HelloWorldThread ERROR: " + e);
			}
		}
	}

	public void stopThread() {
		this.running = false;
	}
}