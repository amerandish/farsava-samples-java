package ir.amerandish.farsava.model.request;

public class Config {
    private String audioEncoding;
    private int sampleRateHertz;
    private String languageCode;
    private int maxAlternatives;
    private boolean profanityFilter;
    private String asrModel;
    private String languageModel;

    public Config(String audioEncoding, int sampleRateHertz, String languageCode, int maxAlternatives, boolean profanityFilter, String asrModel, String languageModel) {
        this.audioEncoding = audioEncoding;
        this.sampleRateHertz = sampleRateHertz;
        this.languageCode = languageCode;
        this.maxAlternatives = maxAlternatives;
        this.profanityFilter = profanityFilter;
        this.asrModel = asrModel;
        this.languageModel = languageModel;
    }

    public String getAudioEncoding() {
        return audioEncoding;
    }

    public void setAudioEncoding(String audioEncoding) {
        this.audioEncoding = audioEncoding;
    }

    public int getSampleRateHertz() {
        return sampleRateHertz;
    }

    public void setSampleRateHertz(int sampleRateHertz) {
        this.sampleRateHertz = sampleRateHertz;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public int getMaxAlternatives() {
        return maxAlternatives;
    }

    public void setMaxAlternatives(int maxAlternatives) {
        this.maxAlternatives = maxAlternatives;
    }

    public boolean isProfanityFilter() {
        return profanityFilter;
    }

    public void setProfanityFilter(boolean profanityFilter) {
        this.profanityFilter = profanityFilter;
    }

    public String getAsrModel() {
        return asrModel;
    }

    public void setAsrModel(String asrModel) {
        this.asrModel = asrModel;
    }

    public String getLanguageModel() {
        return languageModel;
    }

    public void setLanguageModel(String languageModel) {
        this.languageModel = languageModel;
    }
}
