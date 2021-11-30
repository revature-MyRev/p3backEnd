package com.revature.myrev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Krishna Mandal
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {
	public ObjectNotFoundException(String msg) {
      super(msg);
	}
}