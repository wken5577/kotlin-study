package javakotlin;

public class Util {
    public double f2c(double fahrenheit) {
        return fahrenheit - new Constants().getFreezingPointInf() * 5 / 9.0;
    }
}
