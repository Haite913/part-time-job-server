package com.team.ptjs.Biz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.ApplianceListDetailDto;
import com.team.ptjs.Api.entity.ApplianceList;
import com.team.ptjs.Api.entity.ApplianceListDetail;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Api.query.PageUtils;
import com.team.ptjs.Api.vo.ApplianceListDetailVo;
import com.team.ptjs.Biz.mapper.ApplianceListDetailMapper;
import com.team.ptjs.Biz.mapper.ApplianceListMapper;
import com.team.ptjs.Biz.service.ApplianceListDetailService;
import com.team.ptjs.Biz.service.ApplianceListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplianceListDetailServiceImpl extends ServiceImpl<ApplianceListDetailMapper, ApplianceListDetail> implements ApplianceListDetailService {
    @Override
    public R onSubmit(ApplianceListDetailDto applianceListDetailDto) {
        try {
            ApplianceListDetail applianceListDetail = new ApplianceListDetail();
            BeanUtils.copyProperties(applianceListDetailDto,applianceListDetail);
            baseMapper.insert(applianceListDetail);
            return R.ok( "申请成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("申请失败");
        }
    }

    @Override
    public R onModify(ApplianceListDetailDto applianceListDetailDto) {
        try {
            ApplianceListDetail applianceListDetail = new ApplianceListDetail();
            BeanUtils.copyProperties(applianceListDetailDto,applianceListDetail);
            baseMapper.update(applianceListDetail);
            return R.ok( "修改申请成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("修改申请成功");
        }
    }

}
