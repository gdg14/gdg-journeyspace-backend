package gdg.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import gdg.domain.Diary;
import gdg.domain.Usr;
import gdg.domain.repository.DiaryRepository;
import gdg.domain.repository.UsrRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DiaryResolver implements GraphQLQueryResolver {
    private final DiaryRepository diaryRepository;

    public List<Diary> getDiaryListByUsr(String usrId){
        log.info("-----" + usrId);
        return diaryRepository.findDiaryByUsr(usrId);
    }

    public Diary getDiaryById(Long diaryId){
        return diaryRepository.findDiaryById(diaryId);
    }

    public List<Diary> getDiaryList(){
        return diaryRepository.findDiary();
    }

    public List<Diary> getDiaryByMonth(String yyyymm){
        return diaryRepository.findDiaryByMonth(yyyymm);
    }


}
