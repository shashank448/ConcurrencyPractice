package org.example.BusyWaitingvsThreadSignalling.BusyWaiting;

public class Customer implements Runnable{
    private final int appointmentId;
    private final TickingBoard tickingBoard;

    public Customer(int appointmentId, TickingBoard tickingBoard) {
        this.appointmentId = appointmentId;
        this.tickingBoard = tickingBoard;
    }

    @Override
    public void run() {
        // Example of Busy waiting.. this should not be used...
        while (!tickingBoard.isMyTurn(appointmentId)){
            System.out.println(appointmentId + " denied entry");
        }
        System.out.println(appointmentId+ " got Entry");
    }
}
