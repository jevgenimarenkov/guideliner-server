package ee.ttu.usability.guideliner.estimation.result;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = OtherResult.TABLE_NAME)
public class OtherResult {

    public static final String TABLE_NAME = "kristi_2";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "URL")
    private String url;

    @Column(name = "POTENTIAL_PROBLEMS")
    private String potentialProblems;


    @Column(name = "KNOWN_PROBLEMS")
    private String knownProblems;

    @Column(name = "CSS")
    private String css;

    @Column(name = "HTML")
    private String html;
}
