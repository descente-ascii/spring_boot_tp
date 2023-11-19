package com.taa.app.controller;

import com.taa.app.service.AppointmentService;
import com.taa.app.dto.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {


    @Autowired
    private AppointmentService appointmentService ;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hey";
    }

    @PostMapping("/create")
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO){
        AppointmentDTO appointment = appointmentService.createAppointment(appointmentDTO);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable("id") Long appointmentId){
        AppointmentDTO appointmentDTO = appointmentService.getAppointmentById(appointmentId);
        return ResponseEntity.ok(appointmentDTO);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments(){
        List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @PutMapping("{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable("id") Long appointId,
                                                            @RequestBody AppointmentDTO updatedAppointment){
        AppointmentDTO appointmentDTO = appointmentService.updateAppointment(appointId, updatedAppointment);
        return ResponseEntity.ok(appointmentDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") Long appointmentId){
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.ok("Appointment deleted successfully!.");
    }
}
