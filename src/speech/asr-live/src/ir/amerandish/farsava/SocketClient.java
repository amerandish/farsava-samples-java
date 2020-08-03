package ir.amerandish.farsava;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.amerandish.farsava.model.response.AsrResponse;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

public class SocketClient extends WebSocketClient {
    public SocketClient(URI serverUri) {
        super(serverUri);
    }

    public SocketClient(URI serverUri, Draft protocolDraft) {
        super(serverUri, protocolDraft);
    }

    public SocketClient(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    public SocketClient(URI serverUri, Draft protocolDraft, Map<String, String> httpHeaders) {
        super(serverUri, protocolDraft, httpHeaders);
    }

    public SocketClient(URI serverUri, Draft protocolDraft, Map<String, String> httpHeaders, int connectTimeout) {
        super(serverUri, protocolDraft, httpHeaders, connectTimeout);
    }

    private String readBase64FromFile(Path filePath) {
        byte[] bytes;

        try {
            bytes = Files.readAllBytes(filePath);
        } catch (IOException e) {
            System.out.printf("file read %s", e.getMessage());
            return null;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        final int BUFFER_SIZE = 16000;
        System.out.println("Connection Opened");
        Path filePath = Paths.get("<YOUR_WAV_FILE_PATH>");
        // read file data
        String base64 = this.readBase64FromFile(filePath);
        if (base64 == null) {
            return;
        }
        System.out.println("sending");
        byte[] buffer = base64.getBytes();
        for (int index = 0; index < buffer.length; index += BUFFER_SIZE) {
            send(Arrays.copyOfRange(buffer, index, index + BUFFER_SIZE));
        }
        System.out.println("send done");
    }

    @Override
    public void onMessage(String s) {
        System.out.printf("Received: %s%n", s);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // parse response data model
            AsrResponse responseModel = objectMapper.readValue(s, AsrResponse.class);
            System.out.println(responseModel);
        } catch (IOException e) {
            System.out.printf("Parse Error: %s%n", e.getMessage());
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.printf("Connection Closed %s", s);
    }

    @Override
    public void onError(Exception e) {
        System.out.printf("Error: %s%n", e.getMessage());
    }
}
