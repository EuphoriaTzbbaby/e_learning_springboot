package tzb.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Users;
import tzb.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/check")
    public boolean checkLogin(@RequestBody Users user) {
        System.out.println("check");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());
        return usersService.checkLogin(user) > 0;
    }
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable long id) {
        return usersService.findById(id);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.findAll();
    }

    @PostMapping
    public String createUser(@RequestBody Users user) {
        int result = usersService.insert(user);
        return result == 1 ? "用户创建成功" : "用户创建失败";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable long id, @RequestBody Users user) {
        user.setId(id);
        int result = usersService.update(user);
        return result == 1 ? "用户更新成功" : "用户更新失败";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        int result = usersService.deleteById(id);
        return result == 1 ? "用户删除成功" : "用户删除失败";
    }
}
