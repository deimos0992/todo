package com.todoapp.demo.controller;

import com.todoapp.demo.dto.NoteDto;
import com.todoapp.demo.model.Note;
import com.todoapp.demo.repository.NoteRepository;
import com.todoapp.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    //Get All Note
    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes(){
        return ResponseEntity.ok(noteservice.getAllNote());
    }

    // Save Single Note
    @PostMapping("/save")
    public ResponseEntity<Note> postSingleNote(@RequestBody NoteDto noteDto){
        Note note = noteservice.saveSingleNote(noteDto);
        return ResponseEntity.ok(note);
    }

    //Get Single Note
    @GetMapping("/note")
    public ResponseEntity<Note> getSingleNote(@RequestParam Long id){
        Note note = noteservice.getSingleNote(id);
        return ResponseEntity.ok(note);
    }

    //Delete Note
    @DeleteMapping("/deleteNote")
    public ResponseEntity<HttpStatus> deleteSingleNote(@RequestParam Long id){
        return ResponseEntity.ok(noteservice.deleteSingleNote(id));
    }

    //Update Note
    @PutMapping("/updateNote")
    public ResponseEntity<Note> updatedNote(
            @RequestBody NoteDto note,
            @RequestParam Long id){
        Note updatedNote = noteservice.updatedNote(note, id);
        return ResponseEntity.ok(updatedNote);
    }
}
