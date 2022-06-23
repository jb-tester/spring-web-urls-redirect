package com.mytests.spring.springweburlscompletion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * *
 * <p>Created by irina on 6/22/2022.</p>
 * <p>Project: spring-web-urls-completion</p>
 * *
 */
@Controller
public class RedirectPPController {
    @Value("${foo-prop1}")
    String p1;
    @Value("${foo-prop2}")
    String p2;
    public static final String SOME_PATH = "ppm0";

    @GetMapping("/re/pp/m0")
    public String rem0() {
        return "redirect:/pp_test/ppm0/buzz"; // try to rename - the 'pp_test' fragment gets lost
    }

    @GetMapping("/re/pp/m00")
    public String rem00() {
        return "redirect:/pp_test" + "/ppm0/buzz"; // not resolved second segment
    }

    @GetMapping("/re/pp/m000")
    public String rem000() {
        return "redirect:/pp_test/" + SOME_PATH + "/buzz"; // not resolved second segment
    }

    @GetMapping("/re/pp/m1")
    public String rem1() {
        return "redirect:/pp_test/ppm1/"+p1;
    }
    @GetMapping("/re/pp/m2/{pv1}")
    public String rem2() {
        return "redirect:/pp_test/ppm2/"+p1+"/{pv1}";
    }
    @GetMapping("/re/pp/m3")
    public String rem3() {
        return "redirect:/pp_test/ppm3/"+p1+"/"+p2;
    }
    @GetMapping("/re/pp/m4")
    public String rem4() {
        return "redirect:/pp_test/ppm1/${foo_prop1}";  // placeholder is not supported here, but that's ok:
        // Spring itself can't substitute it in this case. But probably we should show some warning?
    }
    @GetMapping("/re/pp/m5/{pv1}")
    public String rem5() {
        return "forward:/pp_test/{pv1}/unresolved";  // unresolvable, but resolves to incorrect targets
    }

    @GetMapping("/re/pp/m6")
    public String rem6() {
        return "forward:/";  // try to complete paths from MyControllerWithTopLevelPlaceholder - incorrect
    }
}
