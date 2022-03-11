package com.maxtrain.bootcamp.band;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
//sending and receiving json
@RestController
@RequestMapping("/api/bands")

public class BandController {
	
	@Autowired
	private BandRepository bandRepo;
	
	@GetMapping // ALL
	public ResponseEntity<Iterable<Band>> getBand() {
		var band = bandRepo.findAll();
		return new ResponseEntity<Iterable<Band>>(band, HttpStatus.OK);
	}
	@GetMapping ("{id}") //PK
	public ResponseEntity<Band> getBand(@PathVariable int id) {
		var band = bandRepo.findById(id);
		if(band.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
		return new ResponseEntity<Band>(band.get(), HttpStatus.OK);		
	}
	@PostMapping // ADD POST
	public ResponseEntity<Band> postBand(@RequestBody Band band) {
		if (band == null || band.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		var bnd = bandRepo.save(band);
		return new ResponseEntity<Band>(bnd, HttpStatus.CREATED);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}") // Add PUT
	public ResponseEntity putBand(@PathVariable int id, @RequestBody Band band) {
		if (band == null || band.getId() == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		var bnd = bandRepo.findById(band.getId());
		if(bnd.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		bandRepo.save(band);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity deleteBand(@PathVariable int id) {
		var bnd = bandRepo.findById(id);
		if (bnd.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		bandRepo.delete(bnd.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
