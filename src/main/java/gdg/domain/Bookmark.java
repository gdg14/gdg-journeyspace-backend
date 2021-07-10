package gdg.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "BOOKMARK")
public class Bookmark extends BaseTimeEntity{
    @Id
    @Column(name = "BOOKMARK_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "USR_ID")
    private Usr usr;
    @ManyToOne
    @JoinColumn(name = "DIARY_ID")
    private Diary diary;
}
