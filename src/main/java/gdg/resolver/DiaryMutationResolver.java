package gdg.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import gdg.domain.Comment;
import gdg.domain.Diary;
import gdg.domain.Usr;
import gdg.domain.repository.CommentRepository;
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
    private final CommentRepository commentRepository;

    public boolean saveComment(String usrId, Long diaryId, String content) {
        Usr usr = usrRepository.findById(usrId);
        Diary diary = diaryRepository.findDiaryById(diaryId);
        Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
        SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowStr = fourteen_format.format(date_now);

        Comment comment = Comment.builder()
                .content(content)
                .diary(diary)
                .usr(usr)
                .regDtm(nowStr)
                .updtDtm(nowStr)
                .build();
        return commentRepository.save(comment);
    }

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
