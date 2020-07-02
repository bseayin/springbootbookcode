package com.zz.util;

import com.zz.vo.ResultVO;

/**
 * Created by Bsea
 * 2017-05-15 00:22
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setBody(object);
        resultVO.setErrorCode(-1);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setErrorCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
