package tzb.controller.users;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.ClassStudents;
import tzb.pojo.ClassTeachers;
import tzb.pojo.Users;
import tzb.service.ClassStudentsService;
import tzb.service.ClassTeachersService;
import tzb.service.UsersService;
import tzb.utils.Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private ClassTeachersService classTeachersService;
    @Autowired
    private ClassStudentsService classStudentsService;
    @PostMapping("/check")
    public Users checkLogin(@RequestBody Users user) {
        System.out.println("check");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());
        return usersService.checkLogin(user);
    }
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable long id) {
        return usersService.selectById(id);
    }

    @GetMapping("/selectAll")
    public List<Users> getAllUsers() {
        return usersService.selectAll();
    }
    @GetMapping("/selectStudentsAndTeachers/{id}")
    public List<Users> selectStudentsAndTeachers(@PathVariable long id) {
        List<Users> users = usersService.selectAll();
        HashMap<Long, Users> mp = new HashMap<Long, Users>();
        for(Users user : users){
            mp.put(user.getId(), user);
        }
        List<Users> studentsAndTeachers = new ArrayList<>();
        List<ClassStudents> classStudents = classStudentsService.selectByClassId(id);
        List<ClassTeachers> classTeachers = classTeachersService.selectByClassId(id);
        for(ClassStudents classStudent:classStudents){
            studentsAndTeachers.add(mp.get(classStudent.getStudentId()));
        }
        for(ClassTeachers classTeacher:classTeachers){
            studentsAndTeachers.add(mp.get(classTeacher.getTeacherId()));
        }
        return studentsAndTeachers;
    }
    @GetMapping("/select/{selectVal}/{id}")
    public List<Users> selectBySelectVal(@PathVariable String selectVal, @PathVariable long id) {
        List<Users> users = usersService.selectAll();
        HashMap<Long, Users> mp = new HashMap<Long, Users>();
        for(Users user : users){
            mp.put(user.getId(), user);
        }
        List<Users> studentsAndTeachers = new ArrayList<>();
        List<ClassStudents> classStudents = classStudentsService.selectByClassId(id);
        List<ClassTeachers> classTeachers = classTeachersService.selectByClassId(id);
        for(ClassStudents classStudent:classStudents){
            studentsAndTeachers.add(mp.get(classStudent.getStudentId()));
        }
        for(ClassTeachers classTeacher:classTeachers){
            studentsAndTeachers.add(mp.get(classTeacher.getTeacherId()));
        }
        System.out.println(studentsAndTeachers.size());
        List<Users> ans = new ArrayList<>();
        Match match = new Match();
        for(Users user : studentsAndTeachers){
            if(match.checkContainSubsequence(String.valueOf(user.getId()), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getUsername(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getEmail(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getPassword(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getRole(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getAvatar(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getName(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(String.valueOf(user.getCreatedAt()), selectVal)) {
                ans.add(user);
            }
        }
        return ans;
    }
    @GetMapping("/select/{selectVal}")
    public List<Users> selectBySelectVal(@PathVariable String selectVal) {
        List<Users> users = usersService.selectAll();
        List<Users> ans = new ArrayList<>();
        Match match = new Match();
        for(Users user : users){
            if(match.checkContainSubsequence(String.valueOf(user.getId()), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getUsername(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getEmail(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getPassword(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getRole(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getAvatar(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(user.getName(), selectVal)) {
                ans.add(user);
                continue;
            }
            if(match.checkContainSubsequence(String.valueOf(user.getCreatedAt()), selectVal)) {
                ans.add(user);
            }
        }
        return ans;
    }
    @PostMapping("/insert")
    public String createUser(@RequestBody Users user) {
        int result = usersService.insert(user);
        return result == 1 ? "用户创建成功" : "用户创建失败";
    }

    @PutMapping("/updateById")
    public String updateUser(@RequestBody Users user) {
        int result = usersService.updateById(user);
        return result == 1 ? "用户更新成功" : "用户更新失败";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        int result = usersService.deleteById(id);
        return result == 1 ? "用户删除成功" : "用户删除失败";
    }
}
