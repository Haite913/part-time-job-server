package com.team.ptjs.Api.query;

import lombok.Data;

/**
 * @Author yempty
 * @Description 分页查询表单
 * @Date 2020/5/13 16:31
 */
@Data
public class PageForm {

    private Integer pageNumber = 1;

    private Integer pageSize = 10;

    private String username;

}
