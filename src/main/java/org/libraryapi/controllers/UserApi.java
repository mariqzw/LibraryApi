package org.libraryapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.libraryapi.dto.UserDto;
import org.libraryapi.model.UserModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Tag(name = "users")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface UserApi {
    @Operation(summary = "Создать пользователя")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    void addUser(@Valid @RequestBody UserDto userDto);

    @Operation(summary = "Получить данные пользователя")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    UserModel getUserByUsername(@PathVariable("username") String username);

    @Operation(summary = "Получить данные пользователя по id")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    UserModel getUserById(@PathVariable("id") UUID id);

    @Operation(summary = "Получить список всех пользователей")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    CollectionModel<UserModel> getAllUsers();
}
