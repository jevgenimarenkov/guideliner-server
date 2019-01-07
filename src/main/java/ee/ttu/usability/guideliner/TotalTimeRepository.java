package ee.ttu.usability.guideliner;

import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.TimeUrlEvaluiation;
import org.springframework.data.repository.CrudRepository;

public interface TotalTimeRepository extends CrudRepository<TimeUrlEvaluiation, Long> {
}
