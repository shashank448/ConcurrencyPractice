package org.example.BusyWaitingvsThreadSignalling.ApplyingWaitAndNotify.CustomerAndManagerProblem;

public class Customer implements Runnable {
    private final int appointmentId;
    private final TickingBoard tickingBoard;

    public Customer(int appointmentId, TickingBoard tickingBoard) {
        this.appointmentId = appointmentId;
        this.tickingBoard = tickingBoard;
    }

    @Override
    public void run() {
        synchronized (tickingBoard) {
            while (!tickingBoard.isMyTurn(appointmentId)) {
                System.out.println(appointmentId + " denied Entry");
                try {
                    tickingBoard.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(appointmentId + " got Entry");
            tickingBoard.notifyAll();

        }
    }
}
