package gdg.domain;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Diary extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIARY_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USR_ID")
    private Usr usrId;

    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "FEELINGS")
    private String feelings;
    @Column(name = "PHOTO1")
    private String photo1;
    @Column(name = "PHOTO2")
    private String photo2;
    @Column(name = "PHOTO2")
    private String photo3;
    @Column(name = "CATEGORY")
    private String category;
    //updt, reg dt
}
