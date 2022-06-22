package com.mytests.spring.springweburlscompletion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *
 * <p>Created by irina on 6/21/2022.</p>
 * <p>Project: spring-web-urls-completion</p>
 * *
 */
@RestController
@RequestMapping("/pvtest")
public class ControllerWithPathVars {

    @GetMapping("/{pv1}/m0")
    public String pvm0(@PathVariable String pv1){
        return "pvm0";
    }
    @GetMapping("/m1/hello")
    public String pvm1_0(){
        return "pvm1_0";
    }
    @GetMapping("/m1/bye")
    public String pvm1_1(){
        return "pvm1_1";
    }
    @GetMapping("/m1/{pv1}")
    public String pvm1(@PathVariable String pv1){
        return "pvm1_pv";
    }
    @GetMapping("/m2/{pv1}/{pv2}")
    public String pvm2(@PathVariable String pv1, @PathVariable String pv2){
        return "pvm2";
    }
    @GetMapping("/m3/{pv1}/foo/{pv2}/bar")
    public String pvm3(@PathVariable String pv1, @PathVariable String pv2){
        return "pvm3";
    }
    @GetMapping("/m4-{pv0}/{pv1}-{pv2}")
    public String pvm4(@PathVariable String pv1, @PathVariable String pv2, @PathVariable String pv0){
        return "pvm4";
    }
    @GetMapping("/m5/{pv1}-{pv2}")
    public String pvm5(@PathVariable String pv1, @PathVariable String pv2){
        return "pvm5";
    }
}
