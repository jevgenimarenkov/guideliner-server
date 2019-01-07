package ee.ttu.usability.guideliner.estimation.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@Entity
@Table(name = FailedElement.TABLE_NAME)
public class FailedElement {
	public static final String TABLE_NAME = "failed_element";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;


	private String type;
	private String text;
	private String description;
	private String pathToElement;

	@ManyToOne
	@JoinColumn(name = "Evaluation_Result_Id")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	@JsonIgnore
	private EvaluationResult evaluationResult;
}
