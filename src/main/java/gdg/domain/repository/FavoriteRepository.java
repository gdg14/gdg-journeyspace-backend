package gdg.domain.repository;

import gdg.domain.Favorite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Slf4j
@RequiredArgsConstructor
@Repository
public class FavoriteRepository {
    private final EntityManager em;
    public Favorite findFavorite(String usrId, Long diaryId){
        try{
            return em.createQuery("select l from Favorite l where l.usr.id = :usrId and l.diary.id = :diaryId", Favorite.class)
                    .setParameter("usrId",usrId)
                    .setParameter("diaryId",diaryId)
                    .getSingleResult();
        }catch (Exception e){
            log.error("FavoriteRepository findFavorite: " + e);
            return null;
        }
    }

    public boolean save(Favorite favorite){
        try{
            em.persist(favorite);
            return true;
        }catch (Exception e){
            log.error("save favorite ",e);
            return false;
        }
    }
}
