package com.qf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.dao.ClassMapper;
import com.qf.entity.ClassInfo;
import com.qf.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DingYuHui
 * @Date 2019/9/25
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, ClassInfo> implements IClassService {
    @Autowired
    private ClassMapper classMapper;
}
