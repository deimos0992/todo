package com.todoapp.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "titolo is required")
    @ApiModelProperty(position = 1, value = "titolo", dataType = "String", example = "titolo1")
    private String titolo;
    @NotBlank(message = "titolo is required")
    @ApiModelProperty(position = 2, value = "descrizione", dataType = "String", example = "questa è una descrizione")
    private String descrizione;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @ApiModelProperty(position = 3, value = "createdAt", dataType = "Date", example = "2020-10-21T09:55:30.553Z")
    private Date createdAt;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @ApiModelProperty(position = 4, value = "updateAt", dataType = "Date", example = "2020-10-21T11:55:30.553Z")
    private Date updateAt;


}
