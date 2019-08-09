package project.com.Entity;

public class Polindromes {

    private String polindrome;
    private int count;
    private String min;
    private String max;


    public Polindromes() {
    }

    public Polindromes(String polindrome, int count) {
        this.polindrome = polindrome;
        this.count = count;
    }

    public Polindromes(String polindrome, int count, String min, String max) {
        this.polindrome = polindrome;
        this.count = count;
        this.min = min;
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getPolindrome() {
        return polindrome;
    }

    public void setPolindrome(String polindrome) {
        this.polindrome = polindrome;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}