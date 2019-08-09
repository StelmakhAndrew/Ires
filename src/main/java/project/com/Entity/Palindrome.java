package project.com.Entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Palindrome {

    @NotNull
    @Size(min=2,message = "size must be more than 1")
    @Pattern(regexp = "^[0-9]+$")
    private String palindromeValue;

    @NotNull
    @Min(value = 1,message = "must be more than 0")
    private int count;

    private String min;
    private String max;


    public Palindrome() {
    }

    public Palindrome(String palindromeValue, int count) {
        this.palindromeValue = palindromeValue;
        this.count = count;
    }

    public Palindrome(String palindromeValue, int count, String min, String max) {
        this.palindromeValue = palindromeValue;
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

    public String getPalindromeValue() {
        return palindromeValue;
    }

    public void setPalindromeValue(String palindromeValue) {
        this.palindromeValue = palindromeValue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}