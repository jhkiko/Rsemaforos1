package view;

import java.util.concurrent.Semaphore;

import controller.CaminhadaController;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for(int i = 1; i<=4; i++) {
			Thread t = new CaminhadaController(semaforo, i);
			t.start();
		}
	}

}
