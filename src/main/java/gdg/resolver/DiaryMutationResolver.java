package gdg.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import gdg.domain.Diary;
import gdg.domain.Usr;
import gdg.domain.repository.DiaryRepository;
import gdg.domain.repository.UsrRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
@Transactional
public class DiaryMutationResolver implements GraphQLMutationResolver {
    private final DiaryRepository diaryRepository;
    private final UsrRepository usrRepository;

    public boolean saveDiary(String usrId, String title, String content, String feelings, String category, String publicYN){
        Usr usr = usrRepository.findById(usrId);
        Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
        SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowStr = fourteen_format.format(date_now);

        Diary diary = Diary.builder()
                .usr(usr)
                .title(title)
                .category(category)
                .content(content)
                .feelings(feelings)
                .publicYN(publicYN)
                .updtDtm(nowStr)
                .regDtm(nowStr)
                .build();
        return diaryRepository.save(diary);
    }
}
