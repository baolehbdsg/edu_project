/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.lesson.dao.TeacherDirDao;
import com.hebin.lesson.entity.TeacherDir;
import com.hebin.lesson.service.TeacherDirService;
import org.springframework.stereotype.Service;

@Service("teacherDirService")
public class TeacherDirServiceImpl extends ServiceImpl<TeacherDirDao, TeacherDir> implements TeacherDirService {
}
