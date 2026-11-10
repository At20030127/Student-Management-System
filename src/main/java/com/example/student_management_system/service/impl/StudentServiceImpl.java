package com.example.student_management_system.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.student_management_system.dto.StudentDto;
import com.example.student_management_system.entity.Student;
import com.example.student_management_system.mapper.StudentMapper;
import com.example.student_management_system.repository.StudentRepository;
import com.example.student_management_system.service.StudentService;

import jakarta.validation.Valid;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repository;
	
	
	
	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}



	public List<StudentDto> getAllStudents() {
		List<Student> students=repository.findAll();
		List<StudentDto> studentDtos=students.stream() 
				.map((student)-> StudentMapper.mapToStudentDto(student))
				.collect(Collectors.toList());
		return studentDtos;
	}



	@Override
	public void createStudent(StudentDto studentDto) {
		Student student=StudentMapper.mapToStudent(studentDto);
		repository.save(student);
	}



	@Override
	public StudentDto getStudentById(Long studentId) {
		Student student= repository.findById(studentId).get();
		StudentDto  studentDto=StudentMapper.mapToStudentDto(student);
		return studentDto;
	}



	@Override
	public void updateStudent( StudentDto studentDto) {
		repository.save(StudentMapper.mapToStudent(studentDto));
		
	}



	@Override
	public void deleteStudent(Long studentId) {
		repository.deleteById(studentId);
	
		
		
	}

}
