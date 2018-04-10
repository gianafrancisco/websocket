package client;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

public class MainClient {

    public static void main(String[] args) {

        try {

            String dest = "ws://localhost:8080/time";
            TestClient socket = new TestClient();
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(socket, new URI(dest));

            socket.getLatch().await();
            socket.sendMessage("echo356");
            socket.sendMessage("test356");
            Thread.sleep(10000l);

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
