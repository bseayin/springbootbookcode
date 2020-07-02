package com.zz.controller;

import com.zz.entity.OrderMaster;
import com.zz.entity.WordBook;
import com.zz.service.OrderService;
import com.zz.service.WordBookService;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "单词本Controller")
@RestController
@RequestMapping("wordbook")
public class WordBookController {
    @Resource
    WordBookService wordBookService;

    @ApiOperation(value = "查看单词本", notes = "根据单词id查自己的单词本")
    @ApiImplicitParam(name = "id", value = "单词id", required = true, dataType = "String",paramType = "path")
    @GetMapping("show/{id}")
    public ResultVO getByUserId(@PathVariable("id") String id){
        return ResultVOUtil.success(wordBookService.getByUser(id));
    }


    @ApiOperation(value = "新增单词", notes = "根据单词实体创建单词")
    @ApiImplicitParam(name = "word", value = "单词实体", required = true, dataType = "WordBook")
    @PostMapping("/add")
    public ResultVO addWord(@RequestBody WordBook wordBook) {

        return ResultVOUtil.success(wordBookService.save(wordBook));
    }

}
