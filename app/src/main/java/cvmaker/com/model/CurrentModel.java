package cvmaker.com.model;

public class CurrentModel {
    private String currentOfficeName;
    private String numberOne;
    private String numberTwo;

    public CurrentModel(String currentOfficeName, String numberOne, String numberTwo) {
        this.currentOfficeName = currentOfficeName;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public String getCurrentOfficeName() {
        return currentOfficeName;
    }

    public String getNumberOne() {
        return numberOne;
    }

    public String getNumberTwo() {
        return numberTwo;
    }
}
