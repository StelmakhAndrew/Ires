package project.com.Repository;

import org.springframework.stereotype.Repository;
import project.com.Entity.Polindromes;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PolindromeRepositoryImpl implements PolindromeRepository {

    private static ArrayList<Polindromes> allPolindromes = new ArrayList<>();

    @Override
    public void save(Polindromes polindromes) {
        allPolindromes.add(polindromes);
    }

    @Override
    public List<Polindromes> getAll() {
        return allPolindromes;
    }

    @Override
    public Polindromes getLast() {
        return allPolindromes.get(allPolindromes.size()-1);
    }


}
