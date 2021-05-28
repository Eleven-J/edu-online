package com.bupt.service_edu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.commonutils.R;
import com.bupt.service_edu.entity.EduTeacher;
import com.bupt.service_edu.service.EduTeacherService;
import com.bupt.service_edu.vo.TeacherQuery;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**

 *
 * @author JackieZ
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    //查询所有讲师
    @GetMapping("/findAllTeacher")
    public R findAll(){
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("allTeachers",list);
    }

    //分页查询讲师(有条件)
    @ApiOperation(value = "分页查询讲师")
    @PostMapping("/pageList/{current}/{limit}")
    public R findPage(@PathVariable long current, @PathVariable long limit,
                      @RequestBody(required = false) TeacherQuery teacherQuery){
        //创建page对象,把分页所需要的参数封装到page对象中
        Page<EduTeacher> pageTeacher =new Page<>(current,limit);
        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        //排序条件
        wrapper.orderByDesc("gmt_create");
        //多条件组合查询，与mybatis的动态sql功能一样，只不过现在用mybatisPlus了，换了一种实现形式
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(name)) {
            //构建条件
            wrapper.like("name",name);     //like：like
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);     //eq：等于
        }
        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);//ge:大于等于
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create",end); //le：小于等于
        }
        //调用方法，底层封装
        teacherService.page(pageTeacher,wrapper);
        long total = pageTeacher.getTotal();//获取总记录数
        List<EduTeacher> records = pageTeacher.getRecords();//获取数据（list集合）
        return R.ok().data("total",total).data("rows",records);
    }

    //逻辑删除讲师的方法
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)
                           @PathVariable String id) {
        boolean flag = teacherService.removeById(id);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //添加讲师
    @ApiOperation(value = "添加讲师")
    @PostMapping("/add")
    public R add(@RequestBody EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if(save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //根据id查询讲师
    @ApiOperation(value = "添加讲师")
    @GetMapping("/getTeacher/{id}")
    public R queryById(@PathVariable String id){
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher",eduTeacher);
    }

    //修改讲师信息
    @ApiOperation(value = "修改讲师信息")
    @PostMapping("/updateTeacher")
    public R updateById(@RequestBody EduTeacher eduTeacher){
        boolean flag = teacherService.updateById(eduTeacher);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }

    }
    @GetMapping("/123")
    public R myTest() {
        return R.ok().data("url","hello eleven");
    }
}

