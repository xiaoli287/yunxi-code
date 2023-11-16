package com.goodidea.yunxi.controller;

import com.goodidea.commons.dto.RestResponse;
import com.goodidea.yunxi.service.ICpCouponChannelService;
import com.goodidea.yunxi.vo.CpCouponChannelVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "卡券配置应用渠道") //  tags：你可以当作是这个组的名字。
@RestController
@RequestMapping("/cpcc")
public class CpCouponChannelController {

    @Autowired
    ICpCouponChannelService cpCouponChannelService;


    @ApiOperation(value = "用户测试",notes = "用户测试notes")
    @GetMapping("/test")
    RestResponse<Object> test() {
        return new RestResponse<>();
    }

    @ApiOperation(value = "查询卡券配置应用渠道",notes = "查询卡券配置应用渠道全部数据")
    @GetMapping("/getList")
    RestResponse<Object> getList() {
        return new RestResponse<>(cpCouponChannelService.list());
    }


    @ApiOperation(value = "分页查询卡券配置应用渠道",notes = "分页查询卡券配置应用渠道")
    @PostMapping("/findListByPage")
    RestResponse<Object> findListByPage(@RequestBody CpCouponChannelVo cpCouponChannelVo) {
        return new RestResponse<>(cpCouponChannelService.findListByPage(cpCouponChannelVo));
    }

    @ApiOperation(value = "add卡券配置应用渠道",notes = "新增卡券配置应用渠道")
    @PostMapping("/add")
    RestResponse<Object> add(@RequestBody  @Valid CpCouponChannelVo cpCouponChannelVo) {
        cpCouponChannelService.insertInfo(cpCouponChannelVo);
        return new RestResponse<>();
    }
}
