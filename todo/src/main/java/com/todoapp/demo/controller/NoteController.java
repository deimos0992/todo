package com.todoapp.demo.controller;

import com.todoapp.demo.model.Note;
import com.todoapp.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Note>> getAllNotes(){

        return ResponseEntity.ok(noteRepository.findAll());
    }
}
