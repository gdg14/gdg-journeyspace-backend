package gdg.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "COMMENT")
public class Comment extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USR_ID")
    private Usr usrId;

    @ManyToOne
    @JoinColumn(name = "DIARY_ID")
    private Diary diaryId;

    @Column(name = "CONTENT")
    private String content;
}
