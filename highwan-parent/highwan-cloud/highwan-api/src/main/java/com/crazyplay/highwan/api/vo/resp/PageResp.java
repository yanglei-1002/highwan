package com.crazyplay.highwan.api.vo.resp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResp<T> implements Serializable {
    private List<T> records;
    private long total;
    private long size;
    private long current;
}
