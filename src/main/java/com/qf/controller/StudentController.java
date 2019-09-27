package com.qf.controller;

import com.qf.entity.ClassInfo;
import com.qf.entity.Student;
import com.qf.service.IClassService;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author DingYuHui
 * @Date 2019/9/25
 */
@Controller
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassService classService;

    //查询所有学生信息，并跳转至学生列表
    @RequestMapping("/list")
    public String list(Model map,Long stuClass){
        List<ClassInfo> classList = classService.list();
        List<Student> list = studentService.list();
        map.addAttribute("students",list);
        map.addAttribute("class",classList);

        return "studentList";
    }

    //根据id删除指定学生信息
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        studentService.removeById(id);
        return "redirect:/stu/list";
    }

    //跳转至添加界面
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<ClassInfo> classList = classService.list();
        model.addAttribute("class",classList);
        return "stu_add";
    }

    //添加学生信息
    @RequestMapping("/add")
    public String add(Student student){
        studentService.save(student);
        return "redirect:/stu/list";
    }
    //根据id查询学生信息，并跳转至修改界面
    @RequestMapping("/toUpdate/{id}")
    public String toUpate(@PathVariable Integer id,Model model){
        Student student = studentService.getById(id);
        List<ClassInfo> classList = classService.list();
        model.addAttribute("class",classList);
        model.addAttribute("student",student);
        return "stu_update";
    }

    //修改学生信息
    @RequestMapping("/update")
    public String update(Student student,Model model){
        studentService.updateById(student);
        return "redirect:/stu/list";
    }

    //根据班级查询学生信息
    @RequestMapping("selectStuByClass")
    public String selectStuByClass(Integer stuClass,Model model){
        Student student = studentService.getById(stuClass);
        model.addAttribute("students",student);
        List<ClassInfo> classList = classService.list();
        model.addAttribute("class",classList);
        return "studentList";
    }
}
