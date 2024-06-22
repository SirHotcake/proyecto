package com.example.proyecto.controller;

import com.example.proyecto.model.Reservation;
import com.example.proyecto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations/put")
public class PutReservationController {

    @Autowired
    private ReservationService reservationService;

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        return reservationService.update(id, reservation) != null
                ? ResponseEntity.ok(reservation)
                : ResponseEntity.notFound().build();
    }
}

