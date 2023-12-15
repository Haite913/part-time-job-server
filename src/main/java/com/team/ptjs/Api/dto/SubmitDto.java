package com.team.ptjs.Api.dto;

import lombok.Data;

import java.util.List;

@Data
public class SubmitDto {
    private String name;
    private List<List<Boolean>> schedule;
}
