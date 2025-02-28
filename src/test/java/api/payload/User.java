package api.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	String userName;
	String firstName;
	String lastName;
	String email;
	String password;
	String phone;
	@Builder.Default
	int userStatus = 0;
	int id;

}
