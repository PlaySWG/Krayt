package main;

import java.io.IOException;

import managers.ServerManagerFactory;
import network.login.LoginMessageRegistry;
import kimogila.network.server.GameServer;

public class Core {

	private static Core core;
	
	private boolean shutdownInitiated = false;
	
	private GameServer login;
	
	private ServerManagerFactory managers;
	
	public static void main(String[] args) {
		System.out.println("Starting server...");
		core = new Core();
		
		core.startup();
	}

	// Run all methods that will load up and initialize the Login and Zone servers
	private void startup() {
		startServer(); // start up the zone and login server
		startManagers();

	}
	
	/*private void run() {
		while (!shutdown) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	private boolean startServer() {
		
		try {
			login = new GameServer(44453);
			login.launch();
			login.registerPackets(new LoginMessageRegistry());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Zone and login server opened.");
		return true;
	}
	
	private boolean startManagers() {
		managers = new ServerManagerFactory();
		
		System.out.println("Loading managers...");
		managers.run();
		return true;
	}
	
	public void shutdown() {
		System.out.println("Server shutdown initiated...");
		shutdownInitiated = true;
		
		managers.shutdown();
	}
	
	public boolean isShuttingDown() {
		return shutdownInitiated;
	}
}
