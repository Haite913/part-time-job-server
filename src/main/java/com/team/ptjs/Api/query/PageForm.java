package com.team.ptjs.Api.query;

import lombok.Data;

/**
 * @Author haite
 * @Description 分页查询返回对象
 * @Date 2023/12/07
 */
@Data
public class PageForm {

    private Integer pageNumber = 1;

    private Integer pageSize = 10;

    private String username;

}
