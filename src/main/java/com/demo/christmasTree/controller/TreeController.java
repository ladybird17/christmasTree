package com.demo.christmasTree.controller;

import com.demo.christmasTree.dto.TreeReqDto;
import com.demo.christmasTree.dto.TreeResDto;
import com.demo.christmasTree.entity.Tree;
import com.demo.christmasTree.service.TreeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * author : yjseo
 * date : 2022-12-14
 */

@Controller
public class TreeController {
  public static final String baseUrl = "/tree";

  @Autowired
  TreeService treeService;

  @GetMapping(baseUrl)
  public ModelAndView getTree(){
    List<TreeResDto> treeResDtoList = treeService.getTree();
    ModelAndView mv = new ModelAndView("/tree");
    mv.addObject("treeList", treeResDtoList);
    return mv;
  }

  @GetMapping(baseUrl+"/write")
  public ModelAndView getPostOrnament() throws Exception {
    ModelAndView mv = new ModelAndView("/tree/write");
    return mv;
  }

  @PostMapping(baseUrl+"/write")
  public String postOrnament(@ModelAttribute TreeReqDto treeReqDto) throws Exception {
    treeService.postOrnament(treeReqDto);
    return "redirect:/tree";
  }

  @GetMapping(baseUrl + "/update")
  public ModelAndView getUpdateOrnament(@RequestParam("id") Long id)
      throws Exception {
    ModelAndView mv = new ModelAndView("/tree/update");
    TreeResDto ornament = treeService.getOrnament(id);
    mv.addObject("ornament", ornament);
    return mv;
  }

  @PostMapping(baseUrl + "/update")
  public String updateOrnament(@ModelAttribute TreeReqDto treeReqDto)
      throws Exception {
    treeService.updateOrnament(treeReqDto);
    return "redirect:/tree";
  }

  @DeleteMapping(baseUrl + "/delete/{id}")
  public String deleteOrnament(@RequestParam Long id, @RequestBody TreeReqDto treeReqDto) throws Exception {
    treeService.deleteOrnament(id, treeReqDto);
    return "redirect:/tree";
  }

  @GetMapping(baseUrl + "/ornament/{id}")
  public ModelAndView getOrnament(@PathVariable("id") Long id) throws Exception {
    TreeResDto treeResDto = treeService.getOrnament(id);
    ModelAndView mv = new ModelAndView("/tree/ornament");
    mv.addObject("ornament", treeResDto);
    return mv;
  }

}
