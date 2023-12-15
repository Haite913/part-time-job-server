package com.team.ptjs.Api.query;

import com.team.ptjs.Api.dto.ApplianceListDetailDto;
import lombok.Data;

/**
 *  接受前端发送申请时携带的数据
 */
@Data
public class DataLoad {
    private ApplianceListDetailDto applianceListDetailDto;
    private boolean[][] schedule;
}
