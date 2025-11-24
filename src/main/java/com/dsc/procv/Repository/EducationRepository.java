package com.dsc.procv.Repository;

import com.dsc.procv.Model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {


}
