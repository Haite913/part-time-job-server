package com.team.ptjs.Biz.controller;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Biz.service.ApplianceListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/applianceList" )
public class ApplianceListController {

    @Autowired
    private ApplianceListService applianceListService;

    /**
     *申请列表分页查询
     *
     * @param query
     * @return
     */
    @GetMapping("/apply")
    public R pgeList(PageForm query){
        return R.ok(applianceListService.queryPage(query));
    }
}
