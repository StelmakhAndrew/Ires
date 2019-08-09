package project.com.Repository;

import org.springframework.stereotype.Repository;
import project.com.Entity.Palindrome;

import java.util.List;

@Repository
public interface PalindromeRepository {

    void save(Palindrome document);

    List<Palindrome> getAll();

    Palindrome getLast();
}