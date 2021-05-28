package com.bupt.service_edu.service;

import com.bupt.service_edu.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.service_edu.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author JackieZ
 * @since 2021-05-26
 */
public interface EduSubjectService extends IService<EduSubject> {
    //添加课程分类
    void saveSubject(MultipartFile file, EduSubjectService subjectService);

    //课程分类列表（树形）
    List<OneSubject> getAllOneTwoSubject();
}
