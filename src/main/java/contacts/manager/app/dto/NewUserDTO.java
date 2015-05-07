package contacts.manager.app.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "plainTextPassword")
public class NewUserDTO {

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String plainTextPassword;
}
