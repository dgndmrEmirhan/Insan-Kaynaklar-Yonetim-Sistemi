package com.javareact.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.JobSeekerService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.JobSeeker;
@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {
	
	

		private JobSeekerService jobseekerService;

		@Autowired
		public JobSeekersController(JobSeekerService jobseekerService) {
			super();
			this.jobseekerService = jobseekerService;
		}
			
		@PostMapping("/add")
		public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobseeker){
			return ResponseEntity.ok(this.jobseekerService.add(jobseeker));
		}
//	
//		@PostMapping("/update")
//		public ResponseEntity<?> update(@Valid @RequestBody Jobseeker jobseeker){
//			return ResponseEntity.ok(this.jobseekerService.update(jobseeker));
//		}
//	
//		@PostMapping("/delete")
//		public Result delete(@PathVariable("id") int id){
//			return this.jobseekerService.delete(id);
//		}
//	
//		@GetMapping("/getbyid")
//		public DataResult<Jobseeker> getById(@PathVariable("id") int id){
//			return this.jobseekerService.getById(id);
//		}
		
		@GetMapping("/getall")
		public DataResult<List<JobSeeker>> getAll(){
			return this.jobseekerService.getAll();
		}
}
