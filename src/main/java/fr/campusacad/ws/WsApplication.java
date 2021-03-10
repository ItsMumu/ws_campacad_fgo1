package fr.campusacad.ws;

import fr.campusacad.ws.ctrl.BooksCtrl;
import fr.campusacad.ws.services.BooksService;
import fr.campusacad.ws.services.MQManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;


@SpringBootApplication
public class WsApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = SpringApplication.run(WsApplication.class, args);
        System.out.print("test init");

        try (ZContext context = new ZContext()) {
            // Socket to talk to clients
            ZMQ.Socket socket = context.createSocket(SocketType.REP);
            socket.bind("tcp://*:5555");
            //socket.bind("http://127.0.0.1:8081");

            while (!Thread.currentThread().isInterrupted()) {
                // Block until a message is received
                byte[] reply = socket.recv(0);

                // Print the message
                System.out.println(
                        "Received: [" + new String(reply, ZMQ.CHARSET) + "]"
                );
                String string = new String(reply);
                if(string != null && string.contains("VALIDATE_")){
                    MQManager manager = appContext.getBean(MQManager.class);
                    manager.parseValidateMessage(string);
                    String response = "PANIER_VALIDE";
                    socket.send(response.getBytes(ZMQ.CHARSET), 0);
                }

                // Send a response


            }
    } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
