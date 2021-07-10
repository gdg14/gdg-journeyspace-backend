package gdg.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import gdg.domain.Comment;
import gdg.domain.Diary;
import gdg.domain.Favorite;
import gdg.domain.repository.CommentRepository;
import gdg.domain.repository.DiaryRepository;
import gdg.domain.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DiaryQueryResolver implements GraphQLQueryResolver {
    private final DiaryRepository diaryRepository;
    private final CommentRepository commentRepository;
    private final FavoriteRepository favoriteRepository;

    public List<Diary> getDiaryListByUsr(String usrId){
        log.info("-----" + usrId);
        return diaryRepository.findDiaryByUsr(usrId);
    }

    public Diary getDiaryById(Long diaryId){
        return diaryRepository.findDiaryById(diaryId);
    }

    public List<Diary> getDiaryList(){
        List<Diary> list = diaryRepository.findDiary();
        for (Diary diary:
             list) {
            log.info(diary.getId()+"");
        }
        log.info("--------------------");
        Collections.shuffle(list);
        for (Diary diary:
                list) {
            log.info(diary.getId()+"");
        }
        return list;
    }

    public Diary getDiaryRandom(){
        List<Diary> list = diaryRepository.findDiary();
        for (Diary diary:
                list) {
            log.info(diary.getId()+"");
        }
        log.info("--------------------");
        Collections.shuffle(list);
        for (Diary diary:
                list) {
            log.info(diary.getId()+"");
        }
        return list.get(0);
    }

    public List<Diary> getDiaryByMonth(String yyyymm){
        return diaryRepository.findDiaryByMonth(yyyymm);
    }

    public List<Comment> getComments(Long diaryId){
        return commentRepository.findByDiaryId(diaryId);
    }

    public Favorite getFavorite(String usrId, Long diaryId){return favoriteRepository.findFavorite(usrId, diaryId);}
}
