/**
 * 	This Controller file has been added to practice 
 * 		using JWT tokens without messing with the rest of the project.
 */
package com.revature.myrev.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dipanjali Ghosh
 *
 */

@RestController
@CrossOrigin()
public class TokenDemoController {

	@RequestMapping({ "/hello" })
	public String hello() {
		return "Hello World";
	}

}
