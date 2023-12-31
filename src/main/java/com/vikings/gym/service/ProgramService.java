package com.vikings.gym.service;

import com.vikings.gym.model.Program;
import com.vikings.gym.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramService implements IProgramService{
    private final ProgramRepository programRepository;

    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }
    @Override
    public Program saveProgram(Program program){
        program.setCreateTime(LocalDateTime.now());
        return programRepository.save(program);
    }
    @Override
    public void deleteProgram(Long id){
        programRepository.deleteById(id);
    }
    @Override
    public List<Program> findAllPrograms(){
        return programRepository.findAll();
    }

    @Override
    public Optional<Program> findById(Long id) {
        return this.programRepository.findById(id);
    }
}
