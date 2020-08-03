package ir.amerandish.farsava;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.amerandish.farsava.model.response.HealthModel;
import okhttp3.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String baseUrl = "https://api.amerandish.com/v1";
        String actionUrl = "/speech/healthcheck";
        String authKey = "<YOUR_API_KEY>";

        OkHttpClient client = new OkHttpClient();
        // create request
        Request request = new Request
                .Builder()
                .url(String.format("%s%s", baseUrl, actionUrl))
                .addHeader("Authorization", String.format("bearer %s", authKey))
                .build();

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
                    HealthModel responseModel = objectMapper.readValue(response.body().string(), HealthModel.class);
                    System.out.printf("Response Status Code: %d%n", response.code());
                    System.out.println(responseModel);
                }
            }
        });


    }
}
