package com.dsc.procv.Repository;

import com.dsc.procv.Model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Long> {

}
