package org.example.cloud.seata.service.impl;

import org.example.cloud.seata.dao.StorageDao;
import org.example.cloud.seata.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现类
 *
 * @author Lch on 2020/11/17
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;
    @Override
    public void update(Long id, Integer count) {
        storageDao.update(id,count);
    }
}