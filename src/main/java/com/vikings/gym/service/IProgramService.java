package com.vikings.gym.service;

import com.vikings.gym.model.Program;
import com.vikings.gym.model.User;

import java.util.List;
import java.util.Optional;

public interface IProgramService {

    Program saveProgram(Program program);

    void deleteProgram(Long id);

    List<Program> findAllPrograms();
    Optional<Program> findById(Long id);

}
