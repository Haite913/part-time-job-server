package com.team.ptjs.Biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.ApplianceListDetailDto;
import com.team.ptjs.Api.entity.ApplianceList;
import com.team.ptjs.Api.entity.ApplianceListDetail;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Api.query.PageUtils;

public interface ApplianceListDetailService extends IService<ApplianceListDetail> {

    R onSubmit(ApplianceListDetailDto applianceListDetailDto);

    R onModify(ApplianceListDetailDto applianceListDetailDto);
}
