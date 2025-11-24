package com.dsc.procv.Service;

import com.dsc.procv.Model.Skill;
import com.dsc.procv.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    SkillRepository skillRepository;

    public List<Skill> findAll(){
        return skillRepository.findAll();
    }
}
