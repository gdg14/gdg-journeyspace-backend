package gdg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Bookmark extends BaseTimeEntity{
    @Column(name = "BOOKMARK_ID")
    private Long id;
    @ManyToOne
    @Column(name = "USR_ID")
    private Usr usr;
    @ManyToOne
    @Column(name = "DIARY_ID")
    private Diary diary;
}
