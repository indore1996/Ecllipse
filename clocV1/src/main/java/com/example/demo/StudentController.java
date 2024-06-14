package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;
	
	@GetMapping("/{pageNumber}/{size}")
	public Page<Student> getAll(@PathVariable Integer pageNumber,@PathVariable Integer size,@RequestParam(defaultValue = "id") String sortBy){
		Pageable p = PageRequest.of(pageNumber,size,Sort.by(sortBy));
		
		return studentRepo.findAll(p);
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) throws Exception {
		Student stu = studentRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		return stu;
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable Long id) throws Exception {
		Student stu = studentRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		stu.setId(student.getId());
		stu.setFname(student.getFname());
		stu.setLname(student.getLname());
		stu.setNo(student.getNo());
		
		return studentRepo.save(stu);
	}
	
	@DeleteMapping("/{id}")
	public void delStudent(@PathVariable Long id) {
		studentRepo.deleteById(id);
	}
}
