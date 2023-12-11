package com.team.ptjs.Biz.controller;

import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.entity.Job;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Biz.service.JobDetailService;
import com.team.ptjs.Biz.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private JobService jobService;
    @Autowired
    private JobDetailService jobDetailService;

    /**
     * 统计各个部门的需求人数
     */
    @GetMapping("/eachDepartmentNumbers")
    public R<List<Map.Entry<String, Integer>>> getEachDepartmentNumbers(){
        Map<String, Integer> departmentNumbers = new TreeMap<>();

        // 查询岗位数据
        List<Job> jobList = jobService.list();

        // 统计各个部门的需求人数
        for (Job job : jobList) {
            String department = job.getUnit();
            int requireNumber = job.getRequireNumber();

            if (departmentNumbers.containsKey(department)) {
                requireNumber += departmentNumbers.get(department);
            }

            departmentNumbers.put(department, requireNumber);
        }

        // 返回给前端
        List<Map.Entry<String, Integer>> resultList = new ArrayList<>(departmentNumbers.entrySet());

        return R.ok(resultList);
    }

    /**
     * 统计各个岗位的申请人数
     *
     */
    @GetMapping("/eachPositionApplicantsNumbers")
    public R<List<Map.Entry<String, Integer>>> getEachPositionApplicantsNumbers(){
        Map<String, Integer> positionTitleApplyNumbers = new TreeMap<>();

        // 查询岗位数据
        List<Job> jobList = jobService.list();

        // 统计各个岗位的申请人数
        for (Job job : jobList) {
            String positionTitle = job.getPositionTitle();
            int applyNumber = job.getApplicantNumber();

            if (positionTitleApplyNumbers.containsKey(positionTitle)) {
                applyNumber += positionTitleApplyNumbers.get(positionTitle);
            }

            positionTitleApplyNumbers.put(positionTitle, applyNumber);
        }

        // 返回给前端
        List<Map.Entry<String, Integer>> resultList = new ArrayList<>(positionTitleApplyNumbers.entrySet());

        return R.ok(resultList);
    }

    /**
     * 统计各个岗位的每周工作时长
     */
    @GetMapping("/eachPositionWorkingHours")
    public R<List<Map.Entry<String, Integer>>> getEachPositionWorkingHours(){
        Map<String, Integer> positionTitleWorkingHours = new TreeMap<>();
        // 查询岗位详情数据
        List<JobDetail> jobDetailList=jobDetailService.list();

        // 统计各个岗位的每周工作时长
        for (JobDetail job : jobDetailList) {
            String positionTitle = job.getPositionTitle();
            String workingStr = job.getWorkingWeek();
            int totalHours = calculateTotalHours(workingStr);
            positionTitleWorkingHours.put(positionTitle, totalHours);
        }
        // 返回给前端
        List<Map.Entry<String, Integer>> resultList = new ArrayList<>(positionTitleWorkingHours.entrySet());
        return R.ok(resultList);
    }

    /**
     * 统计各个岗位的薪资水平
     */
    @GetMapping("/eachPositionSalaryLevels")
    public R<List<Map.Entry<String, Integer>>> getEachPositionSalaryLevels(){
        Map<String, Integer> positionSalaryLevels = new TreeMap<>();
        // 查询岗位详情数据
        List<JobDetail> jobDetailList=jobDetailService.list();

        // 统计各个岗位的薪资水平
        for(JobDetail job:jobDetailList){
            String positionTitle = job.getPositionTitle();
            int salary = job.getSalary();
            positionSalaryLevels.put(positionTitle,salary);
        }
        // 返回给前端
        List<Map.Entry<String, Integer>> resultList = new ArrayList<>(positionSalaryLevels.entrySet());
        return R.ok(resultList);
    }

    public static int calculateTotalHours(String inputStr) {
        // 设置正则表达式匹配条件
        String pattern = "周(一|二|三|四|五|六|日)至周(一|二|三|四|五|六|日)，每天(\\d+)小时";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(inputStr);
        // 匹对成功
        if (m.find()) {
            String startDay = m.group(1);
            String endDay = m.group(2);
            int hoursPerDay = Integer.parseInt(m.group(3));

            // 计算工作日数量
            int startIdx = getDayIndex(startDay);
            int endIdx = getDayIndex(endDay);

            int workdaysCount;
            if (startIdx <= endIdx) {
                workdaysCount = endIdx - startIdx + 1;
            } else {
                workdaysCount = 7 - startIdx + endIdx + 1;
            }

            // 计算总小时数
            return workdaysCount * hoursPerDay;
        }
            return -1;
    }

    public static int getDayIndex(String day) {
        switch (day) {
            case "一":
                return 1;
            case "二":
                return 2;
            case "三":
                return 3;
            case "四":
                return 4;
            case "五":
                return 5;
            case "六":
                return 6;
            case "日":
                return 7;
            default:
                return -1;
        }
    }
}
