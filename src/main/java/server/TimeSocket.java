package server;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/time")
public class TimeSocket {

    private UpdateCount updateTask = null;
    private Thread broadcastThread = null;
    public TimeSocket() {
        this.updateTask = new UpdateCount();
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket opened: " + session.getId());
        updateTask.add(session);
        if(broadcastThread == null){
            broadcastThread = new Thread(updateTask);
            broadcastThread.start();
        }
    }
    @OnMessage
    public void onMessage(String txt, Session session) throws IOException {
        System.out.println("Message received: " + txt);
        session.getBasicRemote().sendText(txt.toUpperCase());
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        updateTask.remove(session);
        System.out.println("Closing a WebSocket due to " + reason.getReasonPhrase());
    }
}

