package com.todoapp.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(value = "NoteDto", description = "nota da aggiungere")
public class NoteDto {

    @ApiModelProperty(position = 1, value = "titolo", dataType = "String", example = "titolo1")
    private String titolo;

    @ApiModelProperty(position = 2, value = "descrizione", dataType = "String", example = "questa è una descrizione")
    private String descrizione;
}
