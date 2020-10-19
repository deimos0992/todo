package com.todoapp.demo.service;

import com.todoapp.demo.exception.ResourceNotFoundException;
import com.todoapp.demo.model.Note;
import com.todoapp.demo.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class NoteService {

    private final NoteRepository noteRepository;


    @Transactional
    public Note saveSingleNote(Note payload){
        log.info("INSERIMENTO SINGOLA NOTA");
        Note newNote = new Note();
        newNote.setTitolo(payload.getTitolo());
        newNote.setDescrizione(payload.getDescrizione());
        newNote.setCreatedAt(Date.from(Instant.now()));
        newNote.setUpdateAt(Date.from(Instant.now()));
        return noteRepository.save(newNote);
    }

    @Transactional
    public Note getSingleNote(Long id){
        log.info("RECUPERO SINGOLA NOTA");
        Note singleNote =
                noteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
        return singleNote;
    }

    @Transactional
    public List<Note> getAllNote(){
        log.info("RECUPERA TUTTE LE NOTE");
       return noteRepository.findAll();
    }

    @Transactional
    public HttpStatus deleteSingleNote(Long id){
        Note note = getSingleNote(id);
        if (note != null) {
            noteRepository.delete(note);
            return HttpStatus.OK;
        }else{
            return HttpStatus.NOT_FOUND;
        }
    }



}
