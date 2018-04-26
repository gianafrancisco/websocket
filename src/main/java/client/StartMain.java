package client;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import server.TimeSocket;

public class StartMain {

    public static void main(String ...args) throws Exception {
        Server server = new Server(8080);

        WebSocketHandler wsHandler = new WebSocketHandler()
        {
            @Override
            public void configure(WebSocketServletFactory factory)
            {
                factory.register(TimeSocket.class);
            }
        };
        ContextHandler context = new ContextHandler();
        context.setContextPath("/time");
        context.setHandler(wsHandler);
        server.setHandler(context);

        String webappDirLocation = "src/main/webapp/";
        WebAppContext root = new WebAppContext();
        root.setContextPath("/");
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);
        root.setParentLoaderPriority(true);

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] { context, root });


        server.setHandler(contexts);

        server.start();
        server.join();
    }

}
