package util.lab.interfaces.webapi;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
	
	@GetMapping
	public ResponseEntity<?> getStatus() {
		return ResponseEntity.ok("Server Started.");
	}
	
	@PostMapping
	public ResponseEntity<?> postStatus() throws URISyntaxException {
		return ResponseEntity.created(new URI("/status/new"))
				.body("Status Posted!");
	}
}
