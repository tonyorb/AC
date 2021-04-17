package model;

public enum Operations {

    ADD("add"),
    SUBTRACT("sub"),
    MULTIPLY("mul"),
    DIVIDE("div");

    private final String code;

    Operations(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public String getName(){
        return this.name().toLowerCase();
    }

    public Integer getExpectedResult (Integer val1, Integer val2){
            return switch (this) {
                case ADD -> Math.addExact(val1, val2);
                case SUBTRACT -> Math.subtractExact(val1, val2);
                case MULTIPLY -> Math.multiplyExact(val1, val2);
                case DIVIDE -> val1 / val2;
            };
    }
}
