package project.com.Service;

import org.springframework.stereotype.Service;
import project.com.Entity.Palindrome;

import java.util.List;

@Service
public interface PalindromeService {

    void findPalindromes(Palindrome palindrome);

    List<Palindrome> getAll();
}