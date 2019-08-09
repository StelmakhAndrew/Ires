package project.com.Entity;

public class Pair {
    private String max;
    private String min;

    public Pair(String max, String min) {
        this.max = max;
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }
}
