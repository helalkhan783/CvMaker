package cvmaker.com.model;

public class HospitalMode {
    private  String hospitalName;
    private  String address;
    private String numberOne;
    private String numberTwo;

    public HospitalMode(String fireserviceZoneName, String address, String numberOne, String numberTwo) {
        this.hospitalName = fireserviceZoneName;
        this.address = address;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public String getHospitalName() {
        return hospitalName;
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
