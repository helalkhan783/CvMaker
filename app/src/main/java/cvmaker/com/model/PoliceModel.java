package cvmaker.com.model;

public class PoliceModel {

    private String thanaName;
    private String numberOne;
    private String numberTwo;

    public PoliceModel(String thanaName, String numberOne, String numberTwo) {
        this.thanaName = thanaName;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public String getThanaName() {
        return thanaName;
    }

    public String getNumberOne() {
        return numberOne;
    }

    public String getNumberTwo() {
        return numberTwo;
    }
}
