package edu.missouristate.repository;

import edu.missouristate.domain.Cats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalProjectRepository extends CrudRepository<Cats, Integer> {

}
