package com.todoapp.demo.controller;

import com.todoapp.demo.model.Note;
import com.todoapp.demo.repository.NoteRepository;
import com.todoapp.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteservice;


    @GetMapping("/all")
    public ResponseEntity<List<Note>> getAllNotes(){

        return ResponseEntity.ok(noteRepository.findAll());
    }

    // Save Single Note
    @PostMapping
    public ResponseEntity<Note> postSingleNote(@RequestBody Note noteDto){

        Note note = new Note();
        note = noteservice.saveSingleNote(noteDto);
        return ResponseEntity.ok(note);
    }
}
