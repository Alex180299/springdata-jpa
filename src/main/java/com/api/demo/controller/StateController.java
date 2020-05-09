package com.api.demo.controller;

import com.api.demo.model.State;
import com.api.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController {

    @Autowired
    StateRepository stateRepository;

    @GetMapping("/states")
    public List<State> getStates(){
        return stateRepository.findAll();
    }
}
