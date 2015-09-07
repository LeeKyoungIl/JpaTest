package com.daumkakao.jpa.controller

import com.daumkakao.jpa.bo.HelloWorldBO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

/**
 * Created by kellin on 9/7/15.
 */
@RestController
class HelloWorldController {

    @Autowired
    private HelloWorldBO helloWorldBO

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    ModelAndView helloWorld () {
        println(helloWorldBO.insertUser())

        println(helloWorldBO.getUser())

        new ModelAndView("index")
    }
}
