package com.dsc.procv.Controller;

import com.dsc.procv.Model.Education;
import com.dsc.procv.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/education")
public class EducationController {
    @Autowired
    EducationService educationService;



    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations() {
        // Güvenlik eklendiğinde, burası sadece belirli bir 'User'a ait kayıtları getirecektir.
        List<Education> educations = educationService.findAll();
        return ResponseEntity.ok(educations);
    }

    /**
     * Belirli bir ID'ye sahip eğitim kaydını getirir.
     * Uç: GET /api/educations/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long id) {
        return educationService.findById(id)
                .map(ResponseEntity::ok) // Bulunursa 200 OK ve nesneyi döndür
                .orElseGet(() -> ResponseEntity.notFound().build()); // Bulunamazsa 404 Not Found
    }

    // --- 2. POST (CREATE) OPERASYONU ---

    /**
     * Yeni bir eğitim kaydı oluşturur.
     * Uç: POST /api/educations
     */
    @PostMapping
    // @RequestBody, gelen JSON verisinin doğrudan Education nesnesine dönüştürülmesini sağlar.
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        // Yeni oluşturulan nesneyi Service katmanı üzerinden kaydet.
        Education savedEducation = educationService.save(education);

        // 201 Created durum kodu ve oluşturulan nesneyi döndür.
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEducation);
    }

    // --- 3. PUT (UPDATE) OPERASYONU ---

    /**
     * Belirli bir ID'ye sahip eğitim kaydını günceller.
     * Uç: PUT /api/educations/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education educationDetails) {
        return educationService.findById(id)
                .map(existingEducation -> {
                    // Güncelleme işlemlerini burada yapın. (ID'yi koruyun)
                    existingEducation.setSchoolName(educationDetails.getSchoolName());
                    existingEducation.setDepartment(educationDetails.getDepartment());
                    existingEducation.setDegree(educationDetails.getDegree());
                    existingEducation.setStartDate(educationDetails.getStartDate());
                    existingEducation.setEndDate(educationDetails.getEndDate());
                    existingEducation.setOngoing(educationDetails.isOngoing());
                    // User ilişkisini güncelleme (Genellikle security tarafından yönetilir)
                    // existingEducation.setUser(educationDetails.getUser());

                    Education updatedEducation = educationService.save(existingEducation);
                    return ResponseEntity.ok(updatedEducation); // 200 OK ve güncellenmiş nesne
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 Not Found
    }

    // --- 4. DELETE (DELETE) OPERASYONU ---

    /**
     * Belirli bir ID'ye sahip eğitim kaydını siler.
     * Uç: DELETE /api/educations/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        if (educationService.existsById(id)) {
            educationService.deleteById(id);
            // 204 No Content (İşlem başarılı ama döndürülecek içerik yok)
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }



}
