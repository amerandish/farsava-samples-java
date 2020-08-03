package ir.amerandish.farsava;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Main {


    public static void main(String[] args) throws URISyntaxException {
        String baseUrl = "wss://api.amerandish.com/v1";
        String actionUrl = "/speech/asrlive";
        String authKey = "<YOUR_API_KEY>";

        String url = String.format("%s%s?jwt=%s", baseUrl, actionUrl, authKey);
        SocketClient client = new SocketClient(new URI(url));
        client.connect();
    }
}
