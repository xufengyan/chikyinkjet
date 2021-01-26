package com.zk.chinkjet.service.impl;

import com.zk.chinkjet.dao.FileDao;
import com.zk.chinkjet.entity.UploadFile;
import com.zk.chinkjet.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xf
 * @version 1.0
 * @date 2020/12/31 17:35
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;
    @Override
    public int addFile(UploadFile file) {
        return fileDao.insertFile(file);
    }
}
