package tzb.controller;

import org.springframework.web.bind.annotation.*;
import tzb.pojo.GameRecord;
import tzb.service.GameRecordService;

import java.util.List;

@RestController
@RequestMapping("/game-record")
public class GameRecordController {

    private final GameRecordService service;

    public GameRecordController(GameRecordService service) {
        this.service = service;
    }

    // C: 新增
    @PostMapping("/add")
    public int add(@RequestBody GameRecord record) {
        return service.addGameRecord(record);
    }

    // R1: 查询单条
    @GetMapping("/{id}")
    public GameRecord get(@PathVariable("id") Long id) {
        return service.getGameRecordById(id);
    }

    // R2: 查询全部
    @GetMapping("/all")
    public List<GameRecord> getAll() {
        return service.getAllGameRecords();
    }

    // R3: 查询某用户的记录
    @GetMapping("/user/{userId}")
    public List<GameRecord> getByUser(@PathVariable Long userId) {
        return service.getRecordsByUserId(userId);
    }

    // U: 更新
    @PutMapping("/update")
    public int update(@RequestBody GameRecord record) {
        return service.updateGameRecord(record);
    }

    // D: 删除
    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return service.deleteGameRecord(id);
    }
}