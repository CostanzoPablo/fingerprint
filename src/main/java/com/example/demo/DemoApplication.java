package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.machinezoo.sourceafis.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.io.FileOutputStream;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	public static class Base64Request {
		public String fingerprint1;
		public String fingerprint2;
	}

	@PostMapping("/post")
	public String postData(@RequestBody Base64Request request) throws IOException {
		byte[] imageBytes1 = Base64.getDecoder().decode(request.fingerprint1);
		/*try (FileOutputStream fos = new FileOutputStream("fingerprint1.jpg")) {
			fos.write(imageBytes1);
		}*/

		byte[] imageBytes2 = Base64.getDecoder().decode(request.fingerprint2);
		/*try (FileOutputStream fos = new FileOutputStream("fingerprint2.jpg")) {
			fos.write(imageBytes2);
		}*/

		/*var probe = new FingerprintTemplate(
				new FingerprintImage(Files.readAllBytes(Paths.get("1.jpg"))));
		var candidate = new FingerprintTemplate(
				new FingerprintImage(Files.readAllBytes(Paths.get("2.jpg"))));*/
		var probe = new FingerprintTemplate(
				new FingerprintImage(imageBytes1));
		var candidate = new FingerprintTemplate(
				new FingerprintImage(imageBytes2));
		var matcher = new FingerprintMatcher(probe);
		double similarity = matcher.match(candidate);
		//double threshold = 40;
		//boolean matches = similarity >= threshold;

		return "similarity: " + similarity;
	}
}
