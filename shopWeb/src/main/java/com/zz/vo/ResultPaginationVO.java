package com.zz.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by Bsea
 * 2017-05-12 14:13
 */
@Data
public class ResultPaginationVO<T> extends ResultVO{
    private int next = 0;
    private boolean hasNext = false;
}
