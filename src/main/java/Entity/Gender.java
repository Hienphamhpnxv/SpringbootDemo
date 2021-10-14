package Entity;

public enum Gender {
    MALE(0,"Male"), FEMALE(1,"Female");

    private final int code;
    private final String name;

    Gender(int code, String name){
        this.code = code;
        this.name = name;
    }
    public int getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
}
