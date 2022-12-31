package cvmaker.com.model;

public class FireServiceModel {
    private  String fireserviceZoneName;

    private String numberOne;
    private String numberTwo;

    public FireServiceModel(String fireserviceZoneName, String numberOne, String numberTwo) {
        this.fireserviceZoneName = fireserviceZoneName;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public String getFireserviceZoneName() {
        return fireserviceZoneName;
    }

    public String getNumberOne() {
        return numberOne;
    }

    public String getNumberTwo() {
        return numberTwo;
    }
}
