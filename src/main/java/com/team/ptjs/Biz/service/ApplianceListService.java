package com.team.ptjs.Biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.entity.ApplianceList;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Api.query.PageUtils;

public interface ApplianceListService extends IService<ApplianceList> {
    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageUtils<ApplianceList> queryPage(PageForm query);

    R getDetailById(Integer id);
}
