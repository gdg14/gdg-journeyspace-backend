package gdg.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "USR")
public class Usr {
    @Id
    @Column(name = "USR_ID")
    private String id;

    @Column(name = "NAME")
    private String name;
}
