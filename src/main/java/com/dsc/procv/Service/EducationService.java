package com.dsc.procv.Service;

import com.dsc.procv.Model.Education;
import com.dsc.procv.Repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    @Autowired
    EducationRepository educationRepository;

    public List<Education> findAll(){
        return educationRepository.findAll();
    }

    public Optional<Education> findById(Long id){
        return educationRepository.findById(id);
    }

    public Education save(Education education){
        return educationRepository.save(education);
    }

    public boolean existsById(Long id) {
        // Repository'nin JpaRepository'den gelen yerleşik metodunu çağırır.
        return educationRepository.existsById(id);
    }

    @Modifying
    public void deleteById(Long id) {
        // Repository'nin JpaRepository'den gelen yerleşik metodunu çağırır.
        educationRepository.deleteById(id);
    }
}
