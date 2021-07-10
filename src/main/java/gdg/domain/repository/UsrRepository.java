package gdg.domain.repository;

import gdg.domain.Diary;
import gdg.domain.Usr;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Slf4j
@RequiredArgsConstructor
@Repository
public class UsrRepository {
    private final EntityManager em;

    public Usr findById(String usrId){
        try{
            return em.createQuery("select u from Usr u where u.id = :usrId ", Usr.class)
                    .setParameter("usrId",usrId)
                    .getSingleResult();
        }catch (Exception e){
            log.error("DiaryRepository findDiaryByUsr: " + e);
            return null;
        }
    }
}
