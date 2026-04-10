package tzb.service;

import org.springframework.stereotype.Service;
import tzb.mapper.GameRecordMapper;
import tzb.pojo.GameRecord;

import java.util.List;

@Service
public class GameRecordServiceImpl implements GameRecordService {

    private final GameRecordMapper mapper;

    public GameRecordServiceImpl(GameRecordMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int addGameRecord(GameRecord record) {
        return mapper.insert(record);
    }

    @Override
    public GameRecord getGameRecordById(Long recordId) {
        return mapper.selectById(recordId);
    }

    @Override
    public List<GameRecord> getAllGameRecords() {
        return mapper.selectAll();
    }

    @Override
    public List<GameRecord> getRecordsByUserId(Long userId) {
        return mapper.selectByUserId(userId);
    }

    @Override
    public int updateGameRecord(GameRecord record) {
        return mapper.update(record);
    }

    @Override
    public int deleteGameRecord(Long recordId) {
        return mapper.delete(recordId);
    }
}