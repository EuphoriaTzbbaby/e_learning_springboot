package tzb.controller.Attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Attendance;
import tzb.service.AttendanceService;

@RestController
@RequestMapping("/attendance/add")
public class AttendanceAddController {

    @Autowired
    private AttendanceService service;

    @PostMapping
    public String add(@RequestBody Attendance attendance) {
        return service.addAttendance(attendance) > 0 ? "Add Success" : "Add Failed";
    }
}
