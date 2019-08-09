package project.com.Repository;

import org.springframework.stereotype.Repository;
import project.com.Entity.Polindromes;

import java.util.List;

@Repository
public interface PolindromeRepository {

    void save(Polindromes document);

    List<Polindromes> getAll();

    Polindromes getLast();
}