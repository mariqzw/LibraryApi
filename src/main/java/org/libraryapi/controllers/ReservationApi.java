package org.libraryapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.libraryapi.dto.ReservationDto;

import org.libraryapi.model.ReservationModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;


@Tag(name = "reservations")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface ReservationApi {
    @Operation(summary = "Создать бронирование")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    void addReservation(@Valid @RequestBody ReservationDto reservationDto, String username);

    @Operation(summary = "Получить бронирования пользователя по ID")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    CollectionModel<ReservationModel> getReservationsByUser(@PathVariable("id") UUID id);

    @Operation(summary = "Получить бронирования пользователя по имени пользователя")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    CollectionModel<ReservationModel> getReservationsByUsername(@PathVariable("username") String username);

    @Operation(summary = "Получить все бронирования")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    CollectionModel<ReservationModel> getAllReservations();
}
