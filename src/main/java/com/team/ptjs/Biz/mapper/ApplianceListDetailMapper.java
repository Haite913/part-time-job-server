package com.team.ptjs.Biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.team.ptjs.Api.entity.ApplianceList;
import com.team.ptjs.Api.entity.ApplianceListDetail;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Api.vo.ApplianceListDetailVo;
import com.team.ptjs.Api.vo.ApplianceListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApplianceListDetailMapper extends BaseMapper<ApplianceListDetail> {
    void update(@Param("applianceListDetail") ApplianceListDetail applianceListDetail);

    void delete(@Param("query") PageForm query);

    IPage<ApplianceListVo> queryPage(Page<ApplianceListVo> page, @Param("query") PageForm query);

    ApplianceListDetailVo getDetialById(@Param("query") PageForm query);

    IPage<ApplianceListVo> queryReviewPage(Page<ApplianceListVo> page, PageForm query);
}
