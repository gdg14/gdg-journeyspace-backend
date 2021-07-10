package gdg.domain.repository;

import gdg.domain.Comment;
import gdg.domain.Diary;
import gdg.domain.Usr;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class CommentRepository {
    private final EntityManager em;

    public List<Comment> findByDiaryId(Long diaryId){
        try{
            return em.createQuery("select c from Comment c where c.diary.id = :diaryId ", Comment.class)
                    .setParameter("diaryId",diaryId)
                    .getResultList();
        }catch (Exception e){
            log.error("CommentRepository findByDiaryId: " + e);
            return null;
        }
    }

    public boolean save(Comment comment){
        try{
            em.persist(comment);
            return true;
        }catch (Exception e){
            log.error("saveComment ",e);
            return false;
        }
    }
}
