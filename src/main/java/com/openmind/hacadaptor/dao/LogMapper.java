package com.openmind.hacadaptor.dao;

import com.openmind.hacadaptor.model.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author LiuBin
 * @version Created on 2017/7/17
 */
@Repository
public interface LogMapper extends IBaseMapper<Log> {
    int setWorkNoteStatusClosed(@Param("workNoteNumber") String workNoteNumber, @Param("closeDate") String closeDate);
}
