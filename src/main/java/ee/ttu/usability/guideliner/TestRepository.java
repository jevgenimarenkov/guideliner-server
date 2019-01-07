package ee.ttu.usability.guideliner;

import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<EvaluationResult, Long> {
}
