package com.team.ptjs.Biz.controller;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.ApplianceListDetailDto;
import com.team.ptjs.Api.entity.ApplianceListDetail;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Biz.service.ApplianceListDetailService;
import com.team.ptjs.Biz.service.ApplianceListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/applianceList" )
public class ApplianceListController {

    @Autowired
    private ApplianceListService applianceListService;
    @Autowired
    private ApplianceListDetailService applianceListDetailService;

    /**
     *申请列表分页查询
     *
     * @param query
     * @return
     */
    @GetMapping("/apply")
    public R pageList(PageForm query){
        return R.ok(applianceListService.queryPage(query));
    }

    /**
     *申请列表分页查询
     *
     * @param query
     * @return
     */
    @GetMapping("/apply/detail")
    public R getDetail(PageForm query){
        return R.ok(applianceListService.getDetailById(query));
    }

    /**
     * 提交申请
     *
     * @param applianceListDetailDto
     * @return
     */
    @PostMapping("/apply/submit")
    public R onSubmit(@RequestBody ApplianceListDetailDto applianceListDetailDto){
        return R.ok(applianceListDetailService.onSubmit(applianceListDetailDto));
    }
    /**
     * 修改申请
     *
     * @param applianceListDetailDto
     * @return
     */
    @PostMapping("/apply/modify")
    public R onModify(@RequestBody ApplianceListDetailDto applianceListDetailDto){
        return R.ok(applianceListDetailService.onModify(applianceListDetailDto));
    }
}
