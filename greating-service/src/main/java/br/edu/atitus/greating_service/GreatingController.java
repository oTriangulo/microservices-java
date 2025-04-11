package br.edu.atitus.greating_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greating-service")
public class GreatingController {
	
	@Value("${greating-service.greating}")
	private String greating;
	@Value("${greating-service.default-name}")
	private String defaultName;
	
	@GetMapping({"", "/", "/{namePath}"})
	public ResponseEntity<String> getGreating(
			@PathVariable(required = false) String namePath,
			@RequestParam(required = false) String name
			) {
		if (name == null)
			name = namePath != null ? namePath : defaultName;
		
		String returnText = String.format("%s %s!", greating, name);
		
		return ResponseEntity.ok(returnText);
	}

}
