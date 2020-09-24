package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CaminhadaController extends Thread{
	private Semaphore semaforo;
	private int id;
	private int corredor;
	
	public CaminhadaController(Semaphore semaforo, int id) {
		this.semaforo = semaforo;
		this.id = id;
		this.corredor = 200;
	}
	
	@Override
	public void run() {
		andar();
		try {
			this.semaforo.acquire();
			abrirPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.semaforo.release();
		}
	}
	
	private void andar() {
		Random random = new Random();
		while(this.corredor > 0) {
			this.corredor -= (random.nextInt(2) + 4);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void abrirPorta() {
		Random random = new Random();
		try {
			sleep(random.nextInt(1000) + 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O carinha nº " + this.id + " abrir a porta.");
	}
}
