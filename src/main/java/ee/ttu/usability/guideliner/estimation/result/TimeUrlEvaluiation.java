package ee.ttu.usability.guideliner.estimation.result;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = TimeUrlEvaluiation.TABLE_NAME)
public class TimeUrlEvaluiation {
    public static final String TABLE_NAME = "time_evaluation";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "URL")
    private String url;

    @Column(name = "total")
    private Integer total;
}
