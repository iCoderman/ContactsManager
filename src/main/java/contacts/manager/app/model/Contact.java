package contacts.manager.app.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Getter
	@Setter
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@Getter
	@Setter
	private User user;

	@Column(name="first_name", nullable = false)
	@Getter
	@Setter
	private String firstName;

	@Column(name="last_name", nullable = false)
	@Getter
	@Setter
	private String lastName;

	@Column(nullable = false)
	@Getter
	@Setter
	private String phone;

	@Getter
	@Setter
	private String address;

	@Getter
	@Setter
	private String email;
}