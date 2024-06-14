package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	private CourseRepo studentRepo;
	
	@GetMapping("/{pageNumber}/{size}")
	public Page<Course> getAll(@PathVariable Integer pageNumber,@PathVariable Integer size,@RequestParam(defaultValue = "id") String sortBy){
		Pageable p = PageRequest.of(pageNumber,size,Sort.by(sortBy));
		
		return studentRepo.findAll(p);
	}
	
	@PostMapping
	public Course createStudent(@RequestBody Course student) {
		return studentRepo.save(student);
	}
	
	@GetMapping("/{id}")
	public Course getStudentById(@PathVariable Long id) throws Exception {
		Course stu = studentRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		return stu;
	}
	
	@PutMapping("/{id}")
	public Course updateStudent(@RequestBody Course student, @PathVariable Long id) throws Exception {
		Course stu = studentRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		stu.setId(student.getId());
		stu.setC_name(student.getC_name());
		
		return studentRepo.save(stu);
	}
	
	@DeleteMapping("/{id}")
	public void delStudent(@PathVariable Long id) {
		studentRepo.deleteById(id);
	}
}
