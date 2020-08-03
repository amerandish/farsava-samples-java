package ir.amerandish.farsava.model.request;

public class AsrRequest {
    private Audio audio;
    private Config config;

    public AsrRequest(Audio audio, Config config) {
        this.audio = audio;
        this.config = config;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "AsrRequest{" +
                "audio=" + audio +
                ", config=" + config +
                '}';
    }
}
