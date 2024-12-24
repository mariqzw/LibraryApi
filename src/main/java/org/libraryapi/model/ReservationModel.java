package org.libraryapi.model;

import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

public class ReservationModel extends RepresentationModel<ReservationModel> {
    private LocalDate reservedAt;
    private LocalDate reservedUntil;

    protected ReservationModel() {};

    public ReservationModel(LocalDate reservedAt, LocalDate reservedUntil) {
        this.reservedAt = reservedAt;
        this.reservedUntil = reservedUntil;
    }

    public LocalDate getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDate reservedAt) {
        this.reservedAt = reservedAt;
    }

    public LocalDate getReservedUntil() {
        return reservedUntil;
    }

    public void setReservedUntil(LocalDate reservedUntil) {
        this.reservedUntil = reservedUntil;
    }

}
