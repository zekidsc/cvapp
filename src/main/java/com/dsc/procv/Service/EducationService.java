package com.dsc.procv.Service;

import com.dsc.procv.Model.Education;
import com.dsc.procv.Repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    @Autowired
    EducationRepository educationRepository;

    public List<Education> findAll(){
        return educationRepository.findAll();
    }
}
