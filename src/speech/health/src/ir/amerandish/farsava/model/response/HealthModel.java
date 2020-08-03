package ir.amerandish.farsava.model.response;

public class HealthModel {
    private String status;
    private String version;
    private String message;

    public HealthModel() {
    }

    public HealthModel(String status, String version, String message) {
        this.status = status;
        this.version = version;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HealthModel{" +
                "status='" + status + '\'' +
                ", version='" + version + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
