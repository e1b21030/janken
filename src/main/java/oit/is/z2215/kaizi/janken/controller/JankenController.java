package oit.is.z2215.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2215.kaizi.janken.model.UserMapper;
import oit.is.z2215.kaizi.janken.model.User;
import oit.is.z2215.kaizi.janken.model.MatchMappaer;
import oit.is.z2215.kaizi.janken.model.Match;

//import oit.is.z2215.kaizi.janken.model.Entry;

@Controller
@RequestMapping("/janken")
public class JankenController {

  // @Autowired
  // private Entry room;

  @Autowired
  UserMapper userMapper;
  @Autowired
  MatchMappaer matchMapper;

  /*
   * @GetMapping("/janken01")
   * public String janken01(ModelMap model) {
   * model.addAttribute("name_text", "名前を入力してください");
   * return "janken.html";
   * }
   *
   * @PostMapping("/janken02")
   * public String janken02(@RequestParam String name_text, ModelMap model) {
   * model.addAttribute("name_text", name_text);
   * return "janken.html";
   * }
   */

  @GetMapping("/step1")
  public String Saple51() {
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

  @GetMapping("/janken01")
  public String sample38(Principal prin, ModelMap model) {
    // String loginUser = prin.getName();
    // room.addUser(loginUser);
    // model.addAttribute("room", this.room);

    ArrayList<User> users = userMapper.selectAllByUser();
    ArrayList<Match> matches = matchMapper.selectAllMatch();

    model.addAttribute("users", users);

    model.addAttribute("matches", matches);

    User user = userMapper.selectById(2);
    model.addAttribute("user1", user);

    return "janken.html";
  }

  @GetMapping("/janken02")
  public String sample39(ModelMap model) {

    ArrayList<User> users = userMapper.selectAllByUser();
    model.addAttribute("users", users);
    return "janken.html";
  }

  @GetMapping("/match")
  public String sample40(@RequestParam Integer id, ModelMap model) {
    User vs = userMapper.selectById(id);
    model.addAttribute("vs", vs);
    return "match.html";
  }

  @GetMapping("/fight")
  @Transactional
  public String sample41(Principal prin, @RequestParam Integer select, ModelMap model) {
    String name = prin.getName();
    User user = userMapper.selectByUsername(name);
    int id = user.getId();
    Match match = new Match();
    match.setUser1(id);
    match.setUser2(1);

    if (select == 1) {
      model.addAttribute("your_select", "グー");
      model.addAttribute("cpu_select", "グー");
      model.addAttribute("result", "あいこ");

      match.setUser1Hand("Gu");
      match.setUser2Hand("Gu");
    } else if (select == 2) {
      model.addAttribute("your_select", "チョキ");
      model.addAttribute("cpu_select", "グー");
      model.addAttribute("result", "あなたの負け");

      match.setUser1Hand("Choki");
      match.setUser2Hand("Gu");
    } else if (select == 3) {
      model.addAttribute("your_select", "パー");
      model.addAttribute("cpu_select", "グー");
      model.addAttribute("result", "あなたの勝ち");

      match.setUser1Hand("Pa");
      match.setUser2Hand("Gu");
    }

    matchMapper.insertMatch(match);

    model.addAttribute("match", match);

    return "match.html";
  }

}
