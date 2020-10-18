package com.todoapp.demo.service;

import com.todoapp.demo.model.Note;
import com.todoapp.demo.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    @Transactional
    public Note saveSingleNote(Note payload){
        Note newNote = new Note();
        newNote.setTitolo(payload.getTitolo());
        newNote.setDescrizione(payload.getDescrizione());
        newNote.setCreatedAt(Date.from(Instant.now()));
        newNote.setUpdateAt(Date.from(Instant.now()));
        return noteRepository.save(newNote);
    }


}
