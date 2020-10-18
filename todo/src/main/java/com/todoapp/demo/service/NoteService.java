package com.todoapp.demo.service;

import com.todoapp.demo.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;



}
