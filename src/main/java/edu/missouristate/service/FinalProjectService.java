package edu.missouristate.service;

import edu.missouristate.domain.Cats;
import edu.missouristate.repository.FinalProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinalProjectService {

    @Autowired
    FinalProjectRepository catsRepo;

    public List<Cats> getCats() {
        return (List<Cats>) catsRepo.findAll();
    }

    @Transactional
    public void saveCats(Cats cats) {
        catsRepo.save(cats);
    }

    public Cats getCatsById(Integer id) {
        Optional<Cats> catsOptional = catsRepo.findById(id);
        return catsOptional.isPresent() ? catsOptional.get() : null;
    }

    @Transactional
    public void deleteCat(Integer id){
        catsRepo.deleteById(id);
    }

}
