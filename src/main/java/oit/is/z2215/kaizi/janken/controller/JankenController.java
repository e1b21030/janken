package oit.is.z2215.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/janken")
public class JankenController {

  @GetMapping("/janken01")
  public String janken01(ModelMap model) {
    model.addAttribute("name_text", "名前を入力してください");
    return "janken.html";
  }

  @PostMapping("/janken02")
  public String janken02(@RequestParam String name_text, ModelMap model) {
    model.addAttribute("name_text", name_text);
    return "janken.html";
  }

  @GetMapping("/janken03")
  public String janken03(@RequestParam Integer select, ModelMap model) {
    if (select == 1) {
      model.addAttribute("your_select", "グー");
      model.addAttribute("cpu_select", "グー");
      model.addAttribute("result", "あいこ");
    } else if (select == 2) {
      model.addAttribute("your_select", "チョキ");
      model.addAttribute("cpu_select", "グー");
      model.addAttribute("result", "あなたの負け");
    } else if (select == 3) {
      model.addAttribute("your_select", "パー");
      model.addAttribute("cpu_select", "グー");
      model.addAttribute("result", "あなたの勝ち");
    }
    return "janken.html";
  }
}
