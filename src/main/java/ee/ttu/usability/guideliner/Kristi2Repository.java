package ee.ttu.usability.guideliner;

import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.OtherResult;
import org.springframework.data.repository.CrudRepository;

public interface Kristi2Repository extends CrudRepository<OtherResult, Long> {
}
