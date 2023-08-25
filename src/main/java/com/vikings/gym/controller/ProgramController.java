package com.vikings.gym.controller;

import com.vikings.gym.model.Program;
import com.vikings.gym.service.IProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/program")
public class ProgramController
{
    @Autowired
    private IProgramService programService;
    @PostMapping
    public ResponseEntity<?> saveProgram(@RequestBody Program program)
    {
        return new ResponseEntity<>(programService.saveProgram(program), HttpStatus.CREATED);
    }
    @DeleteMapping("{programId}")
    public ResponseEntity<?> deleteProgram(@PathVariable Long programId)
    {
        programService.deleteProgram(programId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("{programId}")
    public ResponseEntity<?> getProgram(@PathVariable Long programId)
    {
        programService.findById(programId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping//api/program
    public ResponseEntity<?> getAllPrograms()
    {
        return new ResponseEntity<>(programService.findAllPrograms(),HttpStatus.OK);
    }
}
