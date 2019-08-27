package bit.com.a.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionHandlingController {
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Data integrity violation")
	@ExceptionHandler(DataIntegrityViolationException.class)
	public String conflict() {
		return "/main";
	}
}
