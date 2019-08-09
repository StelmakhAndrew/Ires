package project.com.Repository;

import org.springframework.stereotype.Repository;
import project.com.Entity.Palindrome;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PalindromeRepositoryImpl implements PalindromeRepository {

    private static ArrayList<Palindrome> allPalindromes = new ArrayList<>();

    @Override
    public void save(Palindrome palindrome) {
        allPalindromes.add(palindrome);
    }

    @Override
    public List<Palindrome> getAll() {
        return allPalindromes;
    }

    @Override
    public Palindrome getLast() {
        return allPalindromes.get(allPalindromes.size()-1);
    }


}
