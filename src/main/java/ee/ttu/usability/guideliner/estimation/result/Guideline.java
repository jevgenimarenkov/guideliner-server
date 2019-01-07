package ee.ttu.usability.guideliner.estimation.result;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = Guideline.TABLE_NAME)
public class Guideline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	public static final String TABLE_NAME = "guideline_test";

	private String code;
	
	private String name;
	
	private String description;
	
}
