package com.team.ptjs.Biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.ApplianceListDetailDto;
import com.team.ptjs.Api.dto.SubmitDto;
import com.team.ptjs.Api.entity.ApplianceList;
import com.team.ptjs.Api.entity.ApplianceListDetail;
import com.team.ptjs.Api.query.DataLoad;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Api.query.PageUtils;
import com.team.ptjs.Api.vo.ApplianceListDetailVo;
import com.team.ptjs.Api.vo.ApplianceListVo;

import java.util.List;
import java.util.Map;

public interface ApplianceListDetailService extends IService<ApplianceListDetail> {

    R onSubmit(ApplianceListDetailDto applianceListDetailDto);

    R onSubmit1(SubmitDto submitDto);
    R onModify(ApplianceListDetailDto applianceListDetailDto);

    R unSubmit(PageForm query);
    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageUtils<ApplianceListVo> queryPage(PageForm query);

    R getDetailById(PageForm query);

    R getNewDetailById(PageForm query);

    PageUtils<ApplianceListVo> queryReviewPage(PageForm query);

    R onReview(ApplianceListDetailDto applianceListDetailDto);

    PageUtils<ApplianceListDetailVo> comment(PageForm query);
}
