package capstone.hospital.repository;

import capstone.hospital.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByLoginId(String loginId);

    Optional<Patient> findByInfoRrn(String rrn);
}
