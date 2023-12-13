package com.team.ptjs.Biz.controller;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.JobDetailDto;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Api.query.JobQuery;
import com.team.ptjs.Biz.service.JobDetailService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

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
    public R removeById(@PathVariable Long id) {
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

    /**
     * 导出所有岗位信息excel
     */
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportJobDataToExcel() {
        // 获取岗位数据
        List<JobDetail> jobList = jobDetailService.list();

        try (
                // 创建一个基于XML的Excel对象
                Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            // 设置表名
            Sheet sheet = workbook.createSheet("Job Data");
            // 以下数据处理后续可优化
            // 创建表头,并设置各列名称
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("岗位名称");
            header.createCell(1).setCellValue("负责人");
            header.createCell(2).setCellValue("岗位性质");
            header.createCell(3).setCellValue("岗位类型");
            header.createCell(4).setCellValue("需要人数");
            header.createCell(5).setCellValue("申请人数");
            header.createCell(6).setCellValue("在岗人数");
            header.createCell(7).setCellValue("学年");
            header.createCell(8).setCellValue("单位");

            // 填充数据到每个单元
            int rowNum = 1;
            for (JobDetail job : jobList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(job.getPositionTitle());
                row.createCell(1).setCellValue(job.getHead());
                row.createCell(2).setCellValue(job.getPositionNature());
                row.createCell(3).setCellValue(job.getPositionType());
                row.createCell(4).setCellValue(job.getRequireNumber());
                row.createCell(5).setCellValue(job.getApplicantNumber());
                row.createCell(6).setCellValue(job.getJobNumber());
                row.createCell(7).setCellValue(job.getAcademicYear());
                row.createCell(8).setCellValue(job.getUnit());
            }

            // 写入输出流
            workbook.write(out);
            HttpHeaders headers = new HttpHeaders();
            // 设置HTTP响应头Content-Disposition属性值
            headers.add("Content-Disposition", "attachment; filename=job_data.xlsx");
            // 返回给前端
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(out.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

}
