package managers;

import kimogila.managers.ServerManager;
import kimogila.managers.ManagerFactory;

/**
 * Initializes all the managers for the {@link Core}.
 * @author Waverunner
 */
public final class ServerManagerFactory extends ManagerFactory {

	private void createCoreManagers() {
		// TODO: Rename ServerManager to connectionmanager?
		ServerManager connectionMgr = new ServerManager();
		add(connectionMgr);
		
	}
	
	@Override
	public void init() {
		createCoreManagers();
		
	}
}
