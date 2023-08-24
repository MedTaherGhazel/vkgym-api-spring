package com.vikings.gym.service;

import com.vikings.gym.model.Program;

import java.util.List;

public interface IProgramService {

    Program saveProgram(Program program);

    void deleteProgram(Long id);

    List<Program> FindAllPrograms();
}
