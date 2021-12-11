package web.model;

public enum Gender {
    MALE("male"),
    FEMALE("female");
    String valueGender;

    Gender(String gender) {
        this.valueGender = gender;
    }

    public String getValueGender() {
        return valueGender;
    }
}
