package com.team.ptjs.Biz.controller;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.JobDto;
import com.team.ptjs.Api.query.JobQuery;
import com.team.ptjs.Biz.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/job" )
public class JobController {

    private final JobService jobService;


    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @GetMapping("/page")
    public R getPage(JobQuery query) {
        return R.ok(jobService.queryPage(query));
    }

    /**
     * 新增活动
     *
     * @param jobDto
     * @return
     */
    @PostMapping
    public R save(@RequestBody JobDto jobDto) {
        return jobService.saveJob(jobDto);
    }

    /**
     * 通过id删除活动
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Integer id) {
        return R.ok(jobService.deleteById(id));
    }

    /**
     * 修改活动信息
     *
     * @param jobDto
     * @return
     */
    @PutMapping()
    public R updateById(@RequestBody JobDto jobDto) {
        jobService.modifyJob(jobDto);
        return R.ok("编辑成功");
    }

    /**
     * 通过id查询详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Integer id) {
        return jobService.getdetailById(id);
    }
    /**
     * 获取所有单位
     *
     * @return
     */
    @GetMapping("/unit")
    public R getUnit() {
        return jobService.getUnit();
    }
}
