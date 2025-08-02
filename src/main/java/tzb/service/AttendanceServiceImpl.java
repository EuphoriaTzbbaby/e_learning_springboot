package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.AttendanceMapper;
import tzb.pojo.Attendance;
import tzb.service.AttendanceService;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper mapper;

    @Override
    public int addAttendance(Attendance attendance) {
        return mapper.insert(attendance);
    }

    @Override
    public int deleteAttendance(long id) {
        return mapper.deleteById(id);
    }

    @Override
    public Attendance getAttendanceById(long id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return mapper.selectAll();
    }

    @Override
    public int updateAttendance(Attendance attendance) {
        return mapper.update(attendance);
    }
}
