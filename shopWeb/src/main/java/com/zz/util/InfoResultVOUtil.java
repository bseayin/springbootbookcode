package com.zz.util;

import com.zz.vo.InfoResultVO;

public class InfoResultVOUtil {
    public static InfoResultVO success(Object object) {
        InfoResultVO resultVO = new InfoResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static InfoResultVO success() {
        return success(null);
    }

    public static InfoResultVO error(Integer code, String msg) {
        InfoResultVO resultVO = new InfoResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
