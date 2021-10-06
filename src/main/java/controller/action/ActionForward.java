package controller.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 바로 접근이 되지 않기 때문에 롬북 필요?
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionForward {
	boolean isRedirect = false;
	String url;
}
