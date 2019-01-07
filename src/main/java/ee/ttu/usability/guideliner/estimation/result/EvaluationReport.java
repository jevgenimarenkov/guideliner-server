package ee.ttu.usability.guideliner.estimation.result;

import java.util.List;

import lombok.Data;

@Data
public class EvaluationReport {

	private String name;
	
	private String description;
	
	private List<EvaluationResult> results;

}
