package com.todoapp.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NoteDto {

    private String titolo;
    private String descrizione;
}
