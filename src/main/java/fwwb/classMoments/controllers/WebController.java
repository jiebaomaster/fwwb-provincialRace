package fwwb.classMoments.controllers;

import fwwb.classMoments.model.Users;
import fwwb.classMoments.services.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by hongcj on 2017/5/8.
 */

@RequestMapping(value = "/webapp")
@Controller
public class WebController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/form/{formName}", method = RequestMethod.GET)
    public String showApp(
            @PathVariable String formName
    ) {
        return formName;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @RequestMapping("/login")
    public ModelAndView login(
            @RequestParam String phone_num,
            @RequestParam String password,
            ModelAndView modelAndView
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Users users = userService.doLogin(phone_num, password);
        if (users != null) {
            modelAndView.setViewName("redirect:/webapp/admin");
        } else {
            modelAndView.setViewName("redirect:/webapp/form/login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "testAjax", method = RequestMethod.POST)
    public ModelAndView test(
            @RequestBody Map<String, String> map,
            ModelAndView modelAndView
    ) {
        Users users = new Users();
        modelAndView.addObject(users);
        modelAndView.setViewName("redirect:/webapp/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/download/{filename}")
    public ResponseEntity<byte[]> download(
            @PathVariable String filename,
            HttpServletRequest httpServletRequest,
            Model model
    ) throws Exception {
        String path = httpServletRequest.getServletContext().getRealPath("/resources/html/excel/");
        File file = new File(path + File.separator + filename);
        HttpHeaders httpHeaders = new HttpHeaders();
        String downloadFielName;
            downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
            httpHeaders.setContentDispositionFormData("attachment", downloadFielName);
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
    }
//    @RequestMapping(value = "login",method = RequestMethod.POST)
//    public ModelAndView login(
//
//    ) {
//
//    }
}
