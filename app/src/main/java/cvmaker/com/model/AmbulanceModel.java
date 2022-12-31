package cvmaker.com.model;

public class AmbulanceModel {
    private  String ambulanceName;
    private  String address;
    private String numberOne;
    private String numberTwo;

    public AmbulanceModel(String ambulanceName, String address, String numberOne, String numberTwo) {
        this.ambulanceName = ambulanceName;
        this.address = address;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public String getAmbulanceName() {
        return ambulanceName;
    }

    public String getAddress() {
        return address;
    }

    public String getNumberOne() {
        return numberOne;
    }

    public String getNumberTwo() {
        return numberTwo;
    }
}
