package Controller;

import Service.AppointmentService;
import domain.Appointment;
import dto.DtoAppointment;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hey";
    }

    @PostMapping
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
