package capstone.hospital.repository;

import capstone.hospital.domain.QPatient;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static capstone.hospital.domain.QPatient.*;


@Repository
public class PatientQueryRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public PatientQueryRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<String> findLoginId(String name, String phoneNumber) {
        return queryFactory
                .select(patient.loginId)
                .from(patient)
                .where(patient.info.name.eq(name), patient.info.phoneNumber.eq(phoneNumber))
                .fetch();
    }

    public List<String> findLoginPw(String name, String phoneNumber, String loginId) {
        return queryFactory
                .select(patient.loginPw)
                .from(patient)
                .where(patient.info.name.eq(name), patient.info.phoneNumber.eq(phoneNumber), patient.loginId.eq(loginId))
                .fetch();
    }
}
