package com.team.ptjs.Biz.controller;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.ApplianceListDetailDto;
import com.team.ptjs.Api.dto.SubmitDto;
import com.team.ptjs.Api.query.DataLoad;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Biz.service.ApplianceListDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/applianceList" )
public class ApplianceListController {

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
        return R.ok(applianceListDetailService.queryPage(query));
    }

    /**
     *申请列表分页查询
     *
     * @param query
     * @return
     */
    @GetMapping("/review")
    public R pageReviewList(PageForm query){
        return R.ok(applianceListDetailService.queryReviewPage(query));
    }


    /**
     *申请详情
     *
     * @param query
     * @return
     */
    @GetMapping("/apply/detail")
    public R getDetail(PageForm query){
        return R.ok(applianceListDetailService.getDetailById(query));
    }

    /**
     * 空申请详情
     *
     * @param query
     * @return
     */
    @GetMapping("/apply/newDetail")
    public R getNewDetail(PageForm query){
        return R.ok(applianceListDetailService.getNewDetailById(query));
    }

    /**
     * 提交申请
     *
     * @param applianceListDetailDto
     * @return
     */
    @PostMapping("/apply/submitJobInfo")
    public R onSubmit(@RequestBody ApplianceListDetailDto applianceListDetailDto){
        return R.ok(applianceListDetailService.onSubmit(applianceListDetailDto));
    }

    /**
     * 提交申请
     * @param submitDto
     * @return
     */
    @PostMapping("/apply/submit")
    public R onSubmit1(@RequestBody SubmitDto submitDto){
        return R.ok(applianceListDetailService.onSubmit1(submitDto));
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
    /**
     * 审核申请
     *
     * @param applianceListDetailDto
     * @return
     */
    @PostMapping("/apply/review")
    public R onReview(@RequestBody ApplianceListDetailDto applianceListDetailDto){
        return R.ok(applianceListDetailService.onReview(applianceListDetailDto));
    }
    /**
     * 撤销申请
     *
     * @param query
     * @return
     */
    @DeleteMapping("/apply/unSubmit")
    public R unSubmit(PageForm query){
        return R.ok(applianceListDetailService.unSubmit(query));
    }
    /**
     * 查询评分
     *
     * @param query
     * @return
     */
    @GetMapping("/apply/comment")
    public R comment(PageForm query){
        return R.ok(applianceListDetailService.comment(query));
    }
}
