package com.ms.gedcomminer2.controllers;

import com.ms.gedcomminer2.models.Ancestor;
import com.ms.gedcomminer2.services.AncestorServiceImpl;
import com.ms.gedcomminer2.services.IndividualServiceImpl;
import com.ms.gedcomminer2.services.FamilyServiceImpl;
import com.ms.gedcomminer2.services.AncestorBranchServiceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GedcomFileController {
  private final IndividualServiceImpl individualService;
  private final FamilyServiceImpl familyService;
  private final AncestorBranchServiceImpl ancestorBranchService;
  private final AncestorServiceImpl ancestorService;

  @Autowired
  public GedcomFileController(IndividualServiceImpl individualService,
                              FamilyServiceImpl familyService,
                              AncestorBranchServiceImpl ancestorBranchService,
                              AncestorServiceImpl ancestorService) {
    this.individualService = individualService;
    this.familyService = familyService;
    this.ancestorBranchService = ancestorBranchService;
    this.ancestorService = ancestorService;
  }

  /*
  @GetMapping(value = {"/info"})
  public String parse(){
    return "filepicker";
  }
  
   */

  @GetMapping(value = {"/"})
  public String saySuccess() {
    return "done";
  }

  @GetMapping(value = {"/filter"})
  public String filterByIndividual() {
    return "filterancestors";
  }

  @PostMapping(value = {"/filter"})
  public String filterAncestors(@RequestParam String mhId) throws Exception {
    ancestorService.filterAncestors(mhId);
    ancestorBranchService.calculateOccurrences(3);

    return "redirect:/";
  }

  /*
  @PostMapping(value = {"/pickfile"})
  public String parse(@RequestParam String url) throws IOException {
    //families must be parsed first
    familyExtractor.parseFamilies(url);
    extractor.parseIndividuals(url);
     return "redirect:./";
  }
  
   */

  private final String UPLOAD_DIR = "./uploads/";

  @GetMapping("/info")
  public String homepage(String string) {
    return "index";
  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file,
                           RedirectAttributes attributes) {

    // check if file is empty
    if (file.isEmpty()) {
      attributes.addFlashAttribute("message", "Please select a file to upload.");
      return "redirect:/info";
    }

    // normalize the file path
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    // save the file on the local file system
    try {
      Path path = Paths.get(UPLOAD_DIR + fileName);
      Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
      familyService.parseFamilies(path);
      individualService.parseIndividuals(path);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // return success response
    attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

    return "redirect:/";
  }

  @GetMapping(value = {"/select"})
  public String selectForm(String word, Model model) {
    model.addAttribute("word", word);
    return "searchAncestor";
  }

  @PostMapping(value = {"/select"})
  public String listSelected(@RequestParam String word, Model model) {
    model.addAttribute("ancestors", ancestorService.findAncestorsByStringName(word));
    return "ancestorList";
  }

  @GetMapping("/ancestor/edit")
  public String editAncestorForm(Long id, Model model) {
    model.addAttribute("ancestor", this.ancestorService.findById(id));
    return "editAncestor";
  }

  @PostMapping("/ancestor/edit")
  public String saveEditedAncestor(@ModelAttribute("ancestor") Ancestor ancestor, Model model) {
    model.addAttribute("ancestor", this.ancestorService.editById(ancestor));
    return "redirect:/select";
  }

}
