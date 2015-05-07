package contacts.manager.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"encryptedPassword", "contacts"})
@Entity
@Table(name = "users",  uniqueConstraints = {@UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Getter
	@Setter
	private Long id;

	@Column(unique = true, nullable = false)
	@Getter
	@Setter
	private String email;

	@Column(name = "encrypted_password", nullable = false)
	@Getter
	@Setter
	private String encryptedPassword;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@Getter
	@Setter
	private List<Contact> contacts;
}
