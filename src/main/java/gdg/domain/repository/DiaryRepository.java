package gdg.domain.repository;

import gdg.domain.Diary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class DiaryRepository {
    private final EntityManager em;
    public List<Diary> findDiaryByUsr(String usrId){
        try{
            return em.createQuery("select d from Diary d where d.usr.id = :usrId ",Diary.class)
                    .setParameter("usrId",usrId)
                    .getResultList();
        }catch (Exception e){
            log.error("DiaryRepository findDiaryByUsr: " + e);
            return null;
        }
    }

    public Diary findDiaryById(Long diaryId){
        try{
            return em.createQuery("select d from Diary d where d.id = :diaryId",Diary.class)
                    .setParameter("diaryId",diaryId)
                    .getSingleResult();
        }catch (Exception e){
            log.error("findDiaryById" + e);
            return null;
        }
    }

    public List<Diary> findDiary(){
        try{
            return em.createQuery("select d from Diary d where publicYN = 'Y'",Diary.class)
                    .getResultList();
        }catch (Exception e){
            log.error("findDiary" + e);
            return null;
        }
    }

    public List<Diary> findDiaryByMonth(String yyyymm){
        try{
            return em.createQuery("select d from Diary d where d.regDtm LIKE CONCAT('%',:yyyymm,'%')",Diary.class)
                    .setParameter("yyyymm",yyyymm)
                    .getResultList();
        }catch (Exception e){
            log.error("findDiaryByMonth" + e);
            return null;
        }
    }

    public boolean save(Diary diary){
        try{
            em.persist(diary);
            return true;
        }catch (Exception e){
            log.error("saveDiary",e);
            return false;
        }
    }
}
