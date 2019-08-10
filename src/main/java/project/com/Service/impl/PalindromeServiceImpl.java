package project.com.Service.impl;


import org.springframework.stereotype.Service;
import project.com.Entity.Pair;
import project.com.Entity.Palindrome;
import project.com.Repository.PalindromeRepository;
import project.com.Service.PalindromeService;

import java.util.List;

@Service
public class PalindromeServiceImpl implements PalindromeService {


    private final PalindromeRepository palindromeRepository;

    public PalindromeServiceImpl(PalindromeRepository palindromeRepository) {
        this.palindromeRepository = palindromeRepository;
    }

    @Override
    public void findPalindromes(Palindrome palindrome) {
        Pair minMaxPalindromes = getMinMaxPalindromes(palindrome.getPalindromeValue(), palindrome.getCount());
        palindrome.setMax(minMaxPalindromes.getMax());
        palindrome.setMin(minMaxPalindromes.getMin());
        palindromeRepository.save(palindrome);
    }

    @Override
    public List<Palindrome> getAll() {
        return palindromeRepository.findAll();
    }

    private static void generateNextPalindromeUtil(int[] intArrayOfNumber, int len) {
        int mid = len / 2;
        int i = mid - 1;

        int j = (len % 2 == 0) ? mid : mid + 1;

        boolean leftsmaller = false;

        while (i >= 0 && intArrayOfNumber[i] == intArrayOfNumber[j]) {
            i--;
            j++;
        }

        if (i < 0 || intArrayOfNumber[i] < intArrayOfNumber[j]) {
            leftsmaller = true;
        }

        while (i >= 0) {
            intArrayOfNumber[j++] = intArrayOfNumber[i--];
        }

        if (leftsmaller) {
            int carry = 1;

            if (len % 2 == 1) {
                intArrayOfNumber[mid] += 1;
                carry = intArrayOfNumber[mid] / 10;
                intArrayOfNumber[mid] %= 10;
            }
            i = mid - 1;
            j = (len % 2 == 0 ? mid : mid + 1);

            while (i >= 0) {
                intArrayOfNumber[i] = intArrayOfNumber[i] + carry;
                carry = intArrayOfNumber[i] / 10;
                intArrayOfNumber[i] %= 10;
                intArrayOfNumber[j] = intArrayOfNumber[i];
                i--;
                j++;
            }
        }
    }

    private static int[] generateNextPalindrome(int[] intArrayOfNumber, int Len) {

        if (isAll9(intArrayOfNumber, Len)) {
            intArrayOfNumber = new int[intArrayOfNumber.length + 1];
            intArrayOfNumber[0] = 1;
            for (int i = 0; i < Len - 1; i++) {
                intArrayOfNumber[i + 1] = 0;
            }
            intArrayOfNumber[intArrayOfNumber.length - 1] = 1;
        }

        else {
            generateNextPalindromeUtil(intArrayOfNumber, Len);
        }
        return intArrayOfNumber;
    }

    private static boolean isAll9(int[] intArrayOfNumber, int len) {
        for (int i = 0; i < len; i++)
            if (intArrayOfNumber[i] != 9)
                return false;
        return true;
    }

    private static Pair getMinMaxPalindromes(String number, int numberOfPalindromes) {

        int[] intArrayOfNumber = toIntArray(number);
        String minPalindrome;
        String maxPalindrome;
        if(isPalindrome(number)){
            minPalindrome = number;
        }else {
            minPalindrome = toString(generateNextPalindrome(intArrayOfNumber, intArrayOfNumber.length));
        }
        if (numberOfPalindromes == 1) return new Pair(minPalindrome,minPalindrome);

        for (int i = 1; i < numberOfPalindromes - 1; i++) {
            intArrayOfNumber = generateNextPalindrome(intArrayOfNumber, intArrayOfNumber.length);
        }

        maxPalindrome = toString(generateNextPalindrome(intArrayOfNumber, intArrayOfNumber.length));
        return new Pair(maxPalindrome, minPalindrome);
    }

    private static int[] toIntArray(String number) {
        char[] charArrayOfNumber = number.toCharArray();
        int[] intArrayOfNumber = new int[charArrayOfNumber.length];
        for (int i = 0; i < charArrayOfNumber.length; i++) {
            intArrayOfNumber[i] = Character.getNumericValue(charArrayOfNumber[i]);
        }
        return intArrayOfNumber;
    }

    private static String toString(int[] intArrayOfPalindrome){
        StringBuilder stringPalindromeValue = new StringBuilder();

        for (int value : intArrayOfPalindrome) {
            stringPalindromeValue.append(value);
        }
        return String.valueOf(stringPalindromeValue);
    }

    private static boolean isPalindrome(String number) {
        int len = number.length();
        for (int i = 0; i < (len/2); ++i) {
            if (number.charAt(i) != number.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}


