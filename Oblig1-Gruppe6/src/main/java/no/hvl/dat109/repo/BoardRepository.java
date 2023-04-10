package no.hvl.dat109.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat109.model.Square;

/**
 * Repository for Board
 */
public interface BoardRepository extends JpaRepository<Square, Integer> {

}
