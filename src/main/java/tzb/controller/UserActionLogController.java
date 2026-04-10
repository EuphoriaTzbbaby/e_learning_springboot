package tzb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tzb.pojo.UserActionLog;
import tzb.service.UserActionLogService;

import java.util.List;

@RestController
@RequestMapping("/log")
public class UserActionLogController {

    @Autowired
    private UserActionLogService service;

    // 新增日志
    @PostMapping("/add")
    public String add(@RequestBody UserActionLog log) {
        service.addLog(log);
        return "ok";
    }

    // 删除
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "ok";
    }

    // 按用户删除
    @DeleteMapping("/delete/user/{userId}")
    public String deleteByUser(@PathVariable Long userId) {
        service.deleteByUserId(userId);
        return "ok";
    }

    // 根据ID查询
    @GetMapping("/get/{id}")
    public UserActionLog get(@PathVariable Long id) {
        return service.getById(id);
    }

    // 查询全部
    @GetMapping("/all")
    public List<UserActionLog> all() {
        return service.getAll();
    }

    // 按用户查询
    @GetMapping("/user/{userId}")
    public List<UserActionLog> byUser(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    // 按类型查询
    @GetMapping("/type/{type}")
    public List<UserActionLog> byType(@PathVariable String type) {
        return service.getByType(type);
    }

    // 分页
    @GetMapping("/page")
    public List<UserActionLog> page(@RequestParam int page,
                                    @RequestParam int size) {
        return service.getPage(page, size);
    }

    // 总数
    @GetMapping("/count")
    public int count() {
        return service.countAll();
    }
}