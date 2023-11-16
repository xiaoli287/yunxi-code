package com.goodidea.yunxi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.goodidea.yunxi.entity.CpCouponChannel;
import com.goodidea.yunxi.mapper.CpCouponChannelMapper;
import com.goodidea.yunxi.service.ICpCouponChannelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goodidea.yunxi.vo.CpCouponChannelVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 卡券配置应用渠道表 服务实现类
 * </p>
 *
 * @author xiaoli
 * @since 2023-11-13
 */
@Service
public class CpCouponChannelServiceImpl extends ServiceImpl<CpCouponChannelMapper, CpCouponChannel> implements ICpCouponChannelService {

    @Resource
    CpCouponChannelMapper cpCouponChannelMapper;
    @Override
    public
    Page<CpCouponChannel> findListByPage(CpCouponChannelVo cpCouponChannelVo) {
        Page<CpCouponChannel> page = new Page<>();
        page.setCurrent(cpCouponChannelVo.getPageNo());
        page.setSize(cpCouponChannelVo.getPageSize());
        LambdaQueryWrapper<CpCouponChannel> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(cpCouponChannelVo.getChannelName())) {
            queryWrapper.like(CpCouponChannel::getChannelName, cpCouponChannelVo.getChannelName());
        }
        return page(page,queryWrapper);
    }

    @Override
    public void insertInfo(CpCouponChannelVo cpCouponChannelVo) {
        CpCouponChannel cpCouponChannel = new CpCouponChannel();
        BeanUtils.copyProperties(cpCouponChannelVo,cpCouponChannel);
        cpCouponChannelMapper.insert(cpCouponChannel);
    }
}
