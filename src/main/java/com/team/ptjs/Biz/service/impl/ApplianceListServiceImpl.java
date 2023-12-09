package com.team.ptjs.Biz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.entity.ApplianceList;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Api.query.PageUtils;
import com.team.ptjs.Api.vo.ApplianceListDetailVo;
import com.team.ptjs.Api.vo.JobDetailVo;
import com.team.ptjs.Api.vo.JobVo;
import com.team.ptjs.Biz.mapper.ApplianceListMapper;
import com.team.ptjs.Biz.service.ApplianceListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplianceListServiceImpl extends ServiceImpl<ApplianceListMapper, ApplianceList> implements ApplianceListService {
    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @Override
    public PageUtils<ApplianceList> queryPage(PageForm query) {
        Page<ApplianceList> page = new Page<>(query.getPageNumber(), query.getPageSize());
        IPage<ApplianceList> iPage=baseMapper.queryPage(page,query);
        return new PageUtils<>(iPage);
    }

    @Override
    public R getDetailById(Integer id) {
        try {
            ApplianceListDetailVo applianceListDetailVo = baseMapper.getDetialById(id);
            return R.ok(applianceListDetailVo, "查询成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("查询失败");
        }
    }
}
