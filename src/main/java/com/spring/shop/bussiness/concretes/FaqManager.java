package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.FaqService;
import com.spring.shop.dataAccess.abstracts.FaqDao;
import com.spring.shop.entities.Faq;
import org.springframework.stereotype.Service;

@Service
public class FaqManager implements FaqService {
    private final FaqDao faqDao;

    public FaqManager(FaqDao faqDao) {
        this.faqDao = faqDao;
    }

    @Override
    public void save(Faq faq) {
        this.faqDao.save(faq);
    }
}
