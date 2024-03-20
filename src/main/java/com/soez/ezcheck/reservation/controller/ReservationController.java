package com.soez.ezcheck.reservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soez.ezcheck.entity.Reservation;
import com.soez.ezcheck.reservation.domain.ReservationRequestDTO;
import com.soez.ezcheck.reservation.service.ReservationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/make")
    public void makeReservation(@RequestBody ReservationRequestDTO requestDTO){
        reservationService.addReservation(requestDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteReservation(@RequestBody Reservation requestDTO) {
        boolean deleted = reservationService.deleteReservation(requestDTO);
        if (deleted) {
            return ResponseEntity.ok("Reservation deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete reservation.");
        }
    }
    
}
