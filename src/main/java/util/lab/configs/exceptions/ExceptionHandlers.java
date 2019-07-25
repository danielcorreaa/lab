package util.lab.configs.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import util.lab.configs.exceptions.details.ExceptionDetailResponse;

@ControllerAdvice
@RestController
@Slf4j
public class ExceptionHandlers extends ResponseEntityExceptionHandler{
	
	
	@ResponseBody
	@ExceptionHandler({ BusinessException.class })
	public final ResponseEntity<?> handleBusinessException(RuntimeException ex, WebRequest request) {
		log.warn("Exceção de negócio capturada", ex);

		/*
		 * String resourcePath = null; if (request instanceof ServletWebRequest) {
		 * resourcePath = ((ServletWebRequest) request).getRequest().getRequestURI(); }
		 */

		if (ex instanceof BusinessException) {
			return ResponseEntity.badRequest()
					.body(new ExceptionDetailResponse(LocalDateTime.now(), new String[] { ex.getMessage() }));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ExceptionDetailResponse(LocalDateTime.now(), new String[] { ex.getMessage() }));
		}
	}

}
