package tzb.controller.Attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Attendance;
import tzb.service.AttendanceService;

@RestController
@RequestMapping("/attendance/update")
public class AttendanceUpdateController {

    @Autowired
    private AttendanceService service;

    @PutMapping
    public String update(@RequestBody Attendance attendance) {
        return service.updateAttendance(attendance) > 0 ? "Update Success" : "Update Failed";
    }
}
