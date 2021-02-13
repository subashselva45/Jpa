package io.pragra.learning.jpademo.repo;

import io.pragra.learning.jpademo.domain.RefData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefDataRepo extends JpaRepository<RefData,Long> {

}
