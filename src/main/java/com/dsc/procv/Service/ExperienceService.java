package com.dsc.procv.Service;

import com.dsc.procv.Model.Experience;
import com.dsc.procv.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    @Autowired
    ExperienceRepository experienceRepository;

    public List<Experience> findAll(){
        return experienceRepository.findAll();
    }
}
