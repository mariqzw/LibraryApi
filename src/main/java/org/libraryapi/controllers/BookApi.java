package org.libraryapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.libraryapi.dto.BookDto;

import org.libraryapi.model.BookModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Tag(name = "books")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface BookApi {
    @Operation(summary = "Создать книгу")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    void addBook(@Valid @RequestBody BookDto bookDto);

    @Operation(summary = "Получить информацию о книге по названию")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    BookModel findBookByTitle(@PathVariable("title") String title);

    @Operation(summary = "Получить информацию о книге по идентификатору")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    BookModel findBookById(@PathVariable("id") UUID id);

    @Operation(summary = "Получить список всех книг")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    CollectionModel<BookModel> getAllBooks();
}
