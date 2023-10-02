package com.taa.app.controller;

import com.taa.app.service.AppointmentService;
import com.taa.app.dto.DtoAppointment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {


    private AppointmentService appointmentService = new AppointmentService();

    @GetMapping("/hello")
    public String sayHello(){
        return "Hey";
    }

    @PostMapping("/create")
    public ResponseEntity<DtoAppointment> createAppointment(@RequestBody DtoAppointment dtoAppointment){
        DtoAppointment appointment = appointmentService.createAppointment(dtoAppointment);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DtoAppointment> getAppointmentById(@PathVariable("id") Long appointmentId){
        DtoAppointment dtoAppointment = appointmentService.getAppointmentById(appointmentId);
        return ResponseEntity.ok(dtoAppointment);
    }

    @GetMapping
    public ResponseEntity<List<DtoAppointment>> getAllAppointments(){
        List<DtoAppointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @PutMapping("{id}")
    public ResponseEntity<DtoAppointment> updateAppointment(@PathVariable("id") Long appointId,
                                                            @RequestBody DtoAppointment updatedAppointment){
        DtoAppointment dtoAppointment = appointmentService.updateAppointment(appointId, updatedAppointment);
        return ResponseEntity.ok(dtoAppointment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") Long appointmentId){
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.ok("Appointment deleted successfully!.");
    }
}
