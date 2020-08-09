
# Farsava - ASR live Api (WebSocket)

First create an `API KEY` [here](https://panel.amerandish.com/)

## install dependencies

```
com.fasterxml.jackson.core:jackson-databind:2.7.3
org.java-websocket:Java-WebSocket:1.5.1
```

## configs
```java
String baseUrl = "wss://api.amerandish.com/v1";
String actionUrl = "/speech/asrlive";
String authKey = "<YOUR_API_KEY>";

Path filePath = Paths.get("<YOUR_WAV_FILE_PATH>");
```

## run

open in IntelliJ IDEA then run

