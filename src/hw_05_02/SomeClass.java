package hw_05_02;

public class SomeClass {

    private int var;
    protected String str;

    public SomeClass() { }

    private SomeClass(int var, String str) {
        this.var = var;
        this.str = str;
    }

    private int getVar() {
        return var;
    }
    private void setVar(int var) {
        this.var = var;
    }
    public String getStr() {
        return str;
    }
    public void setStr(String str) {
        this.str = str;
    }


    public void print(String str){
        this.str = str;
        System.out.println("Hello " + str);
    }
    private int anyMethod(int var){
        this.var = var;
        return var;
    }

    @Override
    public String toString() {
        return "SomeClass: " + "var = " + var + ", str = " + str;
    }
}
