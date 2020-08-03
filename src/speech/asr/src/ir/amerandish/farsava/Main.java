package ir.amerandish.farsava;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.amerandish.farsava.model.request.AsrRequest;
import ir.amerandish.farsava.model.request.Audio;
import ir.amerandish.farsava.model.request.Config;
import ir.amerandish.farsava.model.response.AsrResponse;
import okhttp3.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Main {
    private static String readBase64FromFile(Path filePath){
        byte[] bytes;

        try {
            bytes = Files.readAllBytes(filePath);
        } catch (IOException e) {
            System.out.printf("file read %s", e.getMessage());
            return null;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }
    public static void main(String[] args) {
        String baseUrl = "https://api.amerandish.com/v1";
        String actionUrl = "/speech/asr";
        String authKey = "<YOUR_API_KEY>";

        Path filePath = Paths.get("<YOUR_WAV_FILE_PATH>");
        // read file
        String base64 = Main.readBase64FromFile(filePath);
        if(base64 == null){
            // no file data
            return;
        }
        // create audio data model
        Audio audio = new Audio(base64);
        // create config data model
        Config config = new Config("LINEAR16", 16000, "fa", 1, true, "default", "general");
        // create request data model
        AsrRequest payload = new AsrRequest(audio, config);

        ObjectMapper objectMapper = new ObjectMapper();
        String payloadStr;

        try {
            // convert object to json
            payloadStr = objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            System.out.printf("payload %s", e.getMessage());
            return;
        }
        // create request body
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), payloadStr);
        // create client
        OkHttpClient client = new OkHttpClient();
        // create request
        Request request = new Request
                .Builder()
                .url(String.format("%s%s", baseUrl, actionUrl))
                .method("POST", requestBody)
                .addHeader("Authorization", String.format("bearer %s", authKey))
                .build();
        // call request
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // failure
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    // response status code is not 200
                    System.out.println(response.code());
                } else {
                    // response status code is 200
                    ObjectMapper objectMapper = new ObjectMapper();
                    // parse response body
                    AsrResponse responseModel = objectMapper.readValue(response.body().string(), AsrResponse.class);
                    System.out.printf("Response Status Code: %d%n", response.code());
                    System.out.println(responseModel);
                }
            }
        });


    }
}