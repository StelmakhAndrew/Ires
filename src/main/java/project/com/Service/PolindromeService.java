package project.com.Service;

import org.springframework.stereotype.Service;
import project.com.Entity.Polindromes;

import java.util.List;

@Service
public interface PolindromeService {

    void chackPolindrome(Polindromes polindromes);

    List<Polindromes> getAll();
}