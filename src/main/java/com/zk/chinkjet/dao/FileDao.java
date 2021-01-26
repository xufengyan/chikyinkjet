package com.zk.chinkjet.dao;

import com.zk.chinkjet.entity.UploadFile;
import org.springframework.stereotype.Component;

/**
 * @author xf
 * @version 1.0
 * @date 2020/12/31 17:35
 */
@Component
public interface FileDao {
    public int insertFile(UploadFile file);
}
