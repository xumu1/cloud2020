package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 * date: 2020-11-28
 *
 * @author xumu
 */
public interface PaymentService {
    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}
