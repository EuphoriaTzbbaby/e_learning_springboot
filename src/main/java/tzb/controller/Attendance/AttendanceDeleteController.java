package tzb.controller.Attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.service.AttendanceService;

@RestController
@RequestMapping("/attendance/delete")
public class AttendanceDeleteController {

    @Autowired
    private AttendanceService service;

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return service.deleteAttendance(id) > 0 ? "Delete Success" : "Delete Failed";
    }
}
