package com.team.ptjs.Biz.controller;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.JobDetailDto;
import com.team.ptjs.Api.query.JobQuery;
import com.team.ptjs.Biz.service.JobDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/job" )
public class JobDetailController {
    @Autowired
    private final JobDetailService jobDetailService;

    /**
     * 岗位列表分页查询
     *
     * @param query
     * @return
     */
    @GetMapping("/page")
    public R getPage(JobQuery query) {
        return R.ok(jobDetailService.queryPage(query));
    }


    /**
     * 新增工作
     *
     * @param jobDetailDto
     * @return
     */
    @PostMapping
    public R save(@RequestBody JobDetailDto jobDetailDto) {
        return jobDetailService.saveJob(jobDetailDto);
    }

    /**
     * 通过id删除活动
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Integer id) {
        return R.ok(jobDetailService.deleteById(id));
    }

    /**
     * 修改活动信息
     *
     * @param jobDetailDto
     * @return
     */
    @PutMapping()
    public R updateById(@RequestBody JobDetailDto jobDetailDto) {
        jobDetailService.modifyJob(jobDetailDto);
        return R.ok("编辑成功");
    }

    /**
     * 通过id查询详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Long id) {
        return jobDetailService.getdetailById(id);
    }
    /**
     * 获取所有单位
     *
     * @return
     */
    @GetMapping("/unit")
    public R getUnit() {
        return jobDetailService.getUnit();
    }
}
