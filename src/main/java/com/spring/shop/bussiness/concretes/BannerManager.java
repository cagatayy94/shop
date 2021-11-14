package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.BannerService;
import com.spring.shop.dataAccess.abstracts.BannerDao;
import com.spring.shop.entities.Banner;
import org.springframework.stereotype.Service;

@Service
public class BannerManager implements BannerService {
    private final BannerDao bannerDao;

    public BannerManager(BannerDao bannerDao) {
        this.bannerDao = bannerDao;
    }

    @Override
    public void save(Banner banner) {
        this.bannerDao.save(banner);
    }
}
