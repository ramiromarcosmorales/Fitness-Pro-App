package com.marcosmorales.modelo;

import java.time.LocalTime;

public enum HorarioClase {
    H07(LocalTime.of(7, 0)),
    H08(LocalTime.of(8, 0)),
    H09(LocalTime.of(9, 0)),
    H10(LocalTime.of(10, 0)),
    H11(LocalTime.of(11, 0)),
    H12(LocalTime.of(12, 0)),
    H13(LocalTime.of(13, 0)),
    H14(LocalTime.of(14, 0)),
    H15(LocalTime.of(15, 0)),
    H16(LocalTime.of(16, 0)),
    H17(LocalTime.of(17, 0)),
    H18(LocalTime.of(18, 0)),
    H19(LocalTime.of(19, 0)),
    H20(LocalTime.of(20, 0)),
    H21(LocalTime.of(21, 0)),
    H22(LocalTime.of(22, 0));

    private final LocalTime horario;

    HorarioClase(LocalTime horario) {
        this.horario = horario;
    }

    public LocalTime getHorario() {
        return this.horario;
    }
}
