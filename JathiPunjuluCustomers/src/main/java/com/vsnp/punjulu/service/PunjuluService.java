package com.vsnp.punjulu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vsnp.punjulu.model.Punjulu;

@FeignClient("JATHI-PUNJULU")
public interface PunjuluService {

	@GetMapping("/punjulu/all")
	public ResponseEntity<?> showPujulu();
	
	@PostMapping("/punjulu/save")
	public ResponseEntity<?> savePujulu(@RequestBody Punjulu punjulu);
}
