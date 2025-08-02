package tzb.controller.Attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Attendance;
import tzb.service.AttendanceService;

import java.util.List;

@RestController
@RequestMapping("/attendance/query")
public class AttendanceQueryController {

    @Autowired
    private AttendanceService service;

    @GetMapping("/{id}")
    public Attendance getById(@PathVariable long id) {
        return service.getAttendanceById(id);
    }

    @GetMapping("/all")
    public List<Attendance> getAll() {
        return service.getAllAttendances();
    }
}
