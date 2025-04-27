package tzb.controller.users;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.Users;
import tzb.service.UsersService;
import utils.Match;

import java.util.ArrayList;
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
        return usersService.selectById(id);
    }

    @GetMapping("/selectAll")
    public List<Users> getAllUsers() {
        return usersService.selectAll();
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
