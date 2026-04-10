package tzb.service;

import tzb.pojo.GameRecord;

import java.util.List;

public interface GameRecordService {

    int addGameRecord(GameRecord record);

    GameRecord getGameRecordById(Long recordId);

    List<GameRecord> getAllGameRecords();

    List<GameRecord> getRecordsByUserId(Long userId);

    int updateGameRecord(GameRecord record);

    int deleteGameRecord(Long recordId);
}