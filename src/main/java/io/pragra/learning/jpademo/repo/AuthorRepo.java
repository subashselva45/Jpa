package io.pragra.learning.jpademo.repo;

import io.pragra.learning.jpademo.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {
}
