package tzb.service;

import tzb.pojo.Attendance;

import java.util.List;

public interface AttendanceService {
    int addAttendance(Attendance attendance);
    int deleteAttendance(long id);
    Attendance getAttendanceById(long id);
    List<Attendance> getAllAttendances();
    int updateAttendance(Attendance attendance);
}
