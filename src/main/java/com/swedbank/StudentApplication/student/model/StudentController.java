package com.swedbank.StudentApplication.student.model;

import com.swedbank.StudentApplication.student.model.exception.CountryNotFoundException;
import com.swedbank.StudentApplication.student.model.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repository;

    @GetMapping()
    public List<Student> all() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) throws StudentNotFoundException {
        Student student = repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        student.setName(newStudent.getName());
        student.setSurname(newStudent.getSurname());
        final var updatedStudent = repository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        repository.save(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable final long id) {
        return new ResponseEntity<>(repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{country}")
    public ResponseEntity<Student> getByCountry(@PathVariable String country) {
        return new ResponseEntity<>(repository.findById(Long.valueOf(country)).orElseThrow(() -> new CountryNotFoundException(country)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getByPersonalNumber/{pnr}")
    public ResponseEntity<Student> getByNr(@PathVariable final long pnr) {
        return new ResponseEntity<>(repository.findByPnr(pnr), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable final long id) {
        repository.deleteById(id);
    }

    @GetMapping("/getByCountry/{country}")
    public Student getCountry(@PathVariable String country) {
        return repository.findByCountry(country);
    }

    @GetMapping("/first")
    public Student getFirst() {
        return repository.getFirstStudent().get(0);
    }

    @GetMapping("/second")
    public Student getSecond() {
        return repository.getSecondStudent().get(0);
    }

    @GetMapping("/byname")
    public List<Student> getByName(@RequestParam() String name) {
        return repository.getByName(name);
    }
}