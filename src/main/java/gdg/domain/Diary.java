package gdg.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "DIARY")
@Builder
public class Diary{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIARY_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USR_ID")
    private Usr usr;

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
    @Column(name = "PHOTO3")
    private String photo3;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "PUBLIC_YN")
    private String publicYN;
    @Column(name = "REG_DTM")
    private String regDtm;
    @Column(name = "UPDT_DTM")
    private String updtDtm;

}
