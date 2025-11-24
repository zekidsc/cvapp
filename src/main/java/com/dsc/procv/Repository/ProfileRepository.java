package com.dsc.procv.Repository;

import com.dsc.procv.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {

}
