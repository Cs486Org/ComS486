package cs486.osgi;

import java.util.Date;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

import org.osgi.framework.Constants;

import de.vpe.firstservice.FirstService;

public class Activator implements BundleActivator, ServiceListener {
	public static BundleContext bc = null;
	private FirstService service;
	private ServiceUserThread thread;

	public void start(BundleContext bc) throws Exception {
		System.out.println("start " + getClass().getName());
		Activator.bc = bc;
		String filter = "(objectclass=" + FirstService.class.getName() + ")";
		bc.addServiceListener(this, filter);
		ServiceReference references[] = bc.getServiceReferences(null, filter);
		for (int i = 0; references != null && i < references.length; i++) {
			this.serviceChanged(new ServiceEvent(ServiceEvent.REGISTERED,
					references[i]));
		}
	}

	public void stop(BundleContext bc) throws Exception {

		System.out.println("Stopping Bundles" + " stopping...");
		this.thread.stop();
		Activator.bc = null;
	}

	@Override
	public void serviceChanged(ServiceEvent event) {
		switch (event.getType()) {
		case ServiceEvent.REGISTERED:
			log("ServiceEvent.REGISTERED");
			this.service = (FirstService) Activator.bc.getService(event
					.getServiceReference());
			this.startUsingService();
			break;
		case ServiceEvent.MODIFIED:
			log("ServiceEvent.MODIFIED received");
			this.stopUsingService();
			this.service = (FirstService) Activator.bc.getService(event
					.getServiceReference());
			this.startUsingService();
			break;
		case ServiceEvent.UNREGISTERING:
			log("ServiceEvent.UNREGISTERING");
			this.stopUsingService();
			break;
		}
	}

	private void stopUsingService() {
		this.thread.stopThread();
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.service = null;
	}

	private void startUsingService() {
		this.thread = new ServiceUserThread(this.service);
		this.thread.start();
	}

	private void log(String message) {
		System.out.println(Activator.bc.getBundle().getHeaders()
				.get(Constants.BUNDLE_NAME)
				+ ": " + message);
	}
}