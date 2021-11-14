package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.SettingService;
import com.spring.shop.dataAccess.abstracts.SettingDao;
import com.spring.shop.entities.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingManager implements SettingService {
    private final SettingDao settingDao;

    @Autowired
    public SettingManager(SettingDao settingDao) {
        this.settingDao = settingDao;
    }

    @Override
    public void save(Setting setting) {
        this.settingDao.save(setting);
    }
}
