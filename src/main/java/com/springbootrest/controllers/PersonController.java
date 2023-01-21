package com.springbootrest.controllers;

import com.springbootrest.data.vo.v1.PersonVO;
import com.springbootrest.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonServices service;

  @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Finds all People", description = "Finds all People",
      tags = {"People"},
      responses = {
          @ApiResponse(description = "Success", responseCode = "200",
              content = {
                  @Content(
                      mediaType = "application/json",
                      array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
                  )
              }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
      }
  )
  public List<PersonVO> findAll() {
    return service.findAll();
  }

  @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Finds a Person", description = "Finds a Person",
      tags = {"People"},
      responses = {
          @ApiResponse(description = "Success", responseCode = "200",
              content = @Content(schema = @Schema(implementation = PersonVO.class))
          ),
          @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
      }
  )
  public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
    return service.findById(id);
  }

  @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Adds a new Person",
      description = "Adds a new Person by passing in a JSON, XML or YML representation of the person!",
      tags = {"People"},
      responses = {
          @ApiResponse(description = "Success", responseCode = "200",
              content = @Content(schema = @Schema(implementation = PersonVO.class))
          ),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
      }
  )
  public PersonVO createPersonVO(@RequestBody PersonVO person) throws Exception {
    return service.createPerson(person);
  }

  @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Updates a Person",
      description = "Updates a Person by passing in a JSON, XML or YML representation of the person!",
      tags = {"People"},
      responses = {
          @ApiResponse(description = "Updated", responseCode = "200",
              content = @Content(schema = @Schema(implementation = PersonVO.class))
          ),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
      }
  )
  public PersonVO updatePersonVO(@RequestBody PersonVO person) {
    return service.updatePerson(person);
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Deletes a Person",
      description = "Deletes a Person by passing in a JSON, XML or YML representation of the person!",
      tags = {"People"},
      responses = {
          @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
      }
  )
  public ResponseEntity<?> deletePersonVO(@PathVariable(value = "id") Long id) {
    service.deletePerson(id);
    return ResponseEntity.noContent().build();
  }

}
