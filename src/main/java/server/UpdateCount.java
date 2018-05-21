package server;

import javax.websocket.Session;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentLinkedQueue;

class UpdateCount implements Runnable {

    private ConcurrentLinkedQueue<Session> sessions;
    private final String endDate = System.getenv("END_DATE") == null ? "2019-06-04T00:00:00" : System.getenv("END_DATE");
    private LocalDateTime endTime = LocalDateTime.parse(endDate);
    private boolean isRunning = true;

    public UpdateCount(){
        sessions = new ConcurrentLinkedQueue<Session>();
    }

    public void add(Session session){
        this.sessions.add(session);
    }

    public void remove(Session session){
        this.sessions.remove(session);
    }

    public void shutdown(){
        this.isRunning = false;
    }

    public void run() {
        while (isRunning){
            try {
                Thread.sleep(500);

                LocalDateTime now = LocalDateTime.now();
                String millis = TimeCalculation.getTimeLeft(now, endTime);
                for (Session session: sessions)
                {
                    session.getBasicRemote().sendText( millis);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch ( IOException e) {
                e.printStackTrace();
            }
        }
    }
}