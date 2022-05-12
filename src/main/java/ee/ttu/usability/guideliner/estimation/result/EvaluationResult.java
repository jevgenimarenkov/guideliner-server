package ee.ttu.usability.guideliner.estimation.result;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = EvaluationResult.TABLE_NAME)
public class EvaluationResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	public static final String TABLE_NAME = "evaluation_result2";

	@Enumerated(EnumType.STRING)
	private ElementType elementType;

	@Enumerated(EnumType.STRING)
	private ResultType result = ResultType.UNKNOWN;

	@OneToMany(mappedBy = "evaluationResult", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FailedElement> failedElements = new ArrayList<FailedElement>();

//	private Guideline guideline;

	private String description;

	private String URL;

	private String guidelineCode;

	private String guidelineName;

	private String guidelineDescription;

	private Long evaluationTime;

	public static EvaluationResult EMPTY_RESULT = new EvaluationResult();
}
