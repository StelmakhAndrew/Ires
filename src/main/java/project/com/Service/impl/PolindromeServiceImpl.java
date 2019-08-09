package project.com.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.com.Entity.Pair;
import project.com.Entity.Polindromes;
import project.com.Repository.PolindromeRepository;
import project.com.Service.PolindromeService;

import java.util.List;

@Service
public class PolindromeServiceImpl implements PolindromeService {

    @Autowired
    private PolindromeRepository polindromeRepository;

    @Override
    public void chackPolindrome(Polindromes polindromes) {
        Pair pair = main(polindromes.getPolindrome(), polindromes.getCount());
        polindromes.setMax(pair.getMax());
        polindromes.setMin(pair.getMin());
        polindromeRepository.save(polindromes);
    }

    @Override
    public List<Polindromes> getAll() {
        return polindromeRepository.getAll();
    }

    private static void generateNextPalindromeUtil(int[] num, int n) {
        int mid = n / 2;
        int i = mid - 1;

        int j = (n % 2 == 0) ? mid : mid + 1;

        boolean leftsmaller = false;

        while (i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }

        if (i < 0 || num[i] < num[j]) {
            leftsmaller = true;
        }

        while (i >= 0) {
            num[j++] = num[i--];
        }

        if (leftsmaller) {
            int carry = 1;

            if (n % 2 == 1) {
                num[mid] += 1;
                carry = num[mid] / 10;
                num[mid] %= 10;
            }
            i = mid - 1;
            j = (n % 2 == 0 ? mid : mid + 1);

            while (i >= 0) {
                num[i] = num[i] + carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j] = num[i];
                i--;
                j++;
            }
        }
    }

    private static int[] generateNextPalindrome(int[] num, int n) {

        if (isAll9(num, n)) {
            num = new int[num.length + 1];
            num[0] = 1;
            for (int i = 0; i < n - 1; i++) {
                num[i + 1] = 0;
            }
            num[num.length - 1] = 1;
        }

        else {
            generateNextPalindromeUtil(num, n);
        }
        return num;
    }

    private static boolean isAll9(int[] num, int n) {
        for (int i = 0; i < n; i++)
            if (num[i] != 9)
                return false;
        return true;
    }

    private static Pair main(String number, int count) {

        int[] num = toNum(number);
        String min;
        String max;
        if(isPalindrome(number)){
            min = number;
        }else {
            min = toString(generateNextPalindrome(num, num.length));
        }

        for (int i = 1; i < count - 1; i++) {
            num = generateNextPalindrome(num, num.length);
        }

        max = toString(generateNextPalindrome(num, num.length));
        return new Pair(max, min);
    }

    private static int[] toNum(String number) {
        char[] numbers = number.toCharArray();
        int[] ints = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            ints[i] = Character.getNumericValue(numbers[i]);
        }
        return ints;
    }

    private static String toString(int[] a){
        StringBuilder result = new StringBuilder();

        for (int value : a) {
            result.append(value);
        }
        return String.valueOf(result);
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}


