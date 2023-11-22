package com.goodidea.yunxi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.goodidea.yunxi.entity.CpCouponChannel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.goodidea.yunxi.vo.CpCouponChannelVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 卡券配置应用渠道表 服务类
 * </p>
 *
 * @author xiaoli
 * @since 2023-11-13
 */
public interface ICpCouponChannelService extends IService<CpCouponChannel> {

    Page<CpCouponChannel> findListByPage(CpCouponChannelVo cpCouponChannelVo);

    void insertInfo(CpCouponChannelVo cpCouponChannelVo);
}
