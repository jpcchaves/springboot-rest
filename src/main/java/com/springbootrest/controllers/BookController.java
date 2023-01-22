package com.springbootrest.controllers;

import com.springbootrest.data.vo.v1.BookVO;
import com.springbootrest.services.BookService;
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
@RequestMapping("/book")
public class BookController {

  @Autowired
  private BookService service;

  @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Finds all books", description = "Finds all books",
      tags = {"Books"},
      responses = {
          @ApiResponse(description = "Success", responseCode = "200",
              content = {
                  @Content(
                      mediaType = "application/json",
                      array = @ArraySchema(schema = @Schema(implementation = BookVO.class))
                  )
              }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
      }
  )
  public List<BookVO> findAll() {
    return service.findAll();
  }

  @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Finds a Book", description = "Finds a Book",
      tags = {"Books"},
      responses = {
          @ApiResponse(description = "Success", responseCode = "200",
              content = @Content(schema = @Schema(implementation = BookVO.class))
          ),
          @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
      }
  )
  public BookVO findById(@PathVariable(value = "id") Long id) throws Exception {
    return service.findById(id);
  }

  @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Adds a new Book",
      description = "Adds a new Book by passing in a JSON a representation of the book!",
      tags = {"Books"},
      responses = {
          @ApiResponse(description = "Success", responseCode = "200",
              content = @Content(schema = @Schema(implementation = BookVO.class))
          ),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
      }
  )
  public BookVO createBook(@RequestBody BookVO book) throws Exception {
    return service.createBook(book);
  }

  @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Updates a Book",
      description = "Updates a Book by passing in a JSON a representation of the book!",
      tags = {"Books"},
      responses = {
          @ApiResponse(description = "Updated", responseCode = "200",
              content = @Content(schema = @Schema(implementation = BookVO.class))
          ),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
      }
  )
  public BookVO updateBook(@RequestBody BookVO book) {
    return service.updateBook(book);
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Deletes a Book",
      description = "Deletes a Book by passing in a JSON a representation of the person!",
      tags = {"Books"},
      responses = {
          @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
      }
  )
  public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long id) {
    service.deleteBook(id);
    return ResponseEntity.noContent().build();
  }

}
