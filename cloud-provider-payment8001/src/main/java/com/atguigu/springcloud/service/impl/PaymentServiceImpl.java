package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 * date: 2020-11-28
 *
 * @author xumu
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return paymentDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Payment record) {
        return paymentDao.insert(record);
    }

    @Override
    public int insertSelective(Payment record) {
        return paymentDao.insertSelective(record);
    }

    @Override
    public Payment selectByPrimaryKey(Long id) {
        return paymentDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Payment record) {
        return paymentDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Payment record) {
        return paymentDao.updateByPrimaryKey(record);
    }
}
