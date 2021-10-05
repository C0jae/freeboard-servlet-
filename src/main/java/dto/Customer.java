package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
//@ToString	@Data 에 ToString 포함이므로 추가하지 않아도 된다.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private int idx;
	private String name;
	private String password;
	private String email;
	private String addr;
	private String gender;
	private int age;
	private String hobby;
}