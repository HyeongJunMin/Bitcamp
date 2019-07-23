package std190722_Servlet2_AJAX.workServlet;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HumanDTO {
	private String name;
	private int age;
	private String gender;
	private String[] hobby;
	private Date birth;
	private int salary;
}
