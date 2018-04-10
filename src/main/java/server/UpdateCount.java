package server;

import org.joda.time.Days;
import org.joda.time.LocalTime;

import javax.websocket.Session;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentLinkedQueue;

class UpdateCount implements Runnable {

    private ConcurrentLinkedQueue<Session> sessions;
    private org.joda.time.LocalDateTime endTime = org.joda.time.LocalDateTime.parse("2019-05-28T00:00:00");
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

                org.joda.time.LocalDateTime now = org.joda.time.LocalDateTime.now();
                int days = Days.daysBetween(now, this.endTime).getDays();

                for (Session session: sessions)
                {
                    session.getBasicRemote().sendText("Days Remaining: " + days);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch ( IOException e) {
                e.printStackTrace();
            }
        }
    }
}