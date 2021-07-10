package gdg.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "COMMENT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USR_ID")
    private Usr usr;

    @ManyToOne
    @JoinColumn(name = "DIARY_ID")
    private Diary diary;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "REG_DTM")
    private String regDtm;

    @Column(name = "UPDT_DTM")
    private String updtDtm;
}
