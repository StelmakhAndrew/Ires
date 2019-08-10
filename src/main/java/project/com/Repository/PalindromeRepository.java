package project.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.com.Entity.Palindrome;


@Repository
public interface PalindromeRepository extends JpaRepository<Palindrome, Long> {
    @Override
    <S extends Palindrome> S save(S s);
}