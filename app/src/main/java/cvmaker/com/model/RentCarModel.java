package cvmaker.com.model;

public class RentCarModel {
    private  String carName;
    private  String address;
    private String numberOne;
    private String numberTwo;

    public RentCarModel(String carName, String address, String numberOne, String numberTwo) {
        this.carName = carName;
        this.address = address;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public String getCarName() {
        return carName;
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
