package contacts.manager.app.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class UserInfoDTO {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String email;
}
