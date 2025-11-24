package com.dsc.procv.Service;

import com.dsc.procv.Model.Profile;
import com.dsc.procv.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public List<Profile> findAll(){
        return profileRepository.findAll();
    }
}
