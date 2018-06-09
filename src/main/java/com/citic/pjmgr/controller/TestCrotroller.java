package com.citic.pjmgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lan on 6/10/18.
 */
//@RestController
@Controller
public class TestCrotroller {

//    http://localhost:8080/greeting
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greet";
    }

//
    @GetMapping("/yo")
    @ResponseBody
    public String hello() {

        return "hello";
    }

    @GetMapping("/yo/{id}")
    @ResponseBody
    public String hello(@PathVariable(name = "id")int id) {
        return "hello"+id;
    }

//    //处理文件上传
//    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
//    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
//                                          HttpServletRequest request) {
//        String contentType = file.getContentType();
//        String fileName = file.getOriginalFilename();
//        /*System.out.println("fileName-->" + fileName);
//        System.out.println("getContentType-->" + contentType);*/
//        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
//        try {
//            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//        //返回json
//        return "uploadimg success";
//    }
}
