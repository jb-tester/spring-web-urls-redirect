package com.mytests.spring.springweburlscompletion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * *
 * <p>Created by irina on 6/21/2022.</p>
 * <p>Project: spring-web-urls-completion</p>
 * *
 */
@Controller
public class RedirectPVController {

    @GetMapping("/re/m0")
    @ResponseBody
    public String rem0() {
        return "rem0";
    }

    @GetMapping("/re/m1")
    public String rem1() {
        return "redirect:/re/m0";
    }

    @GetMapping("/re/m2/{pv0}") // errors are shown falsely for not consumed path variables - https://youtrack.jetbrains.com/issue/IDEA-82795
    public String rem2() {
        return "redirect:/pvtest/m1/{pv0}";
    }

    @GetMapping("/re/m4/{aaa}")
    public String rem4() {
        return "redirect:/pvtest/m1/{aaa}";
    }

    @GetMapping("/re/m3/{pv1}-{pv2}")
    public String rem3(@PathVariable String pv1, @PathVariable String pv2) {
        return "redirect:/pvtest/m3/{pv1}/foo/{pv2}/bar";
    }

    @GetMapping("/re/m5/{aaa}-{bbb}-{ccc}")
    public String rem5() {
        return "redirect:/pvtest/m4-{aaa}/{bbb}-{ccc}"; // navigation doesn't work - https://youtrack.jetbrains.com/issue/IDEA-296516
    }

    @GetMapping("/re/m6/{pv1}/{pv2}")
    public String rem6(@PathVariable String pv1, @PathVariable String pv2) {
        return "redirect:/pvtest/m5/{pv1}-{pv2}";  // navigation doesn't work - https://youtrack.jetbrains.com/issue/IDEA-296516
    }

    @GetMapping("/re/m7/{pv1}/{pv2}")
    public String rem7(@PathVariable String pv1, @PathVariable("pv2") String pv2) {
        return "redirect:/pvtest/m2/{pv1}/{pv2}";  // rename for path vars doesn't affect the usage in redirect: URL - https://youtrack.jetbrains.com/issue/IDEA-296556
    }
}
