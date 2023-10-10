package com.globaroman.erdr_web.controller;

import com.globaroman.erdr_web.service.*;
import com.globaroman.erdr_web.view.OpenFileFromOS;
import com.globaroman.erdr_web.view.PathToFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class WebController {
    private final RAWService rawService;
    private final OpenFileFromOS openFileFromOS;
    private final ActionOneService oneService;
    private final ActionTwoService twoService;
    private final ActionThreeService threeService;
    private final ActionFourService fourService;

    @GetMapping("/main")
    public String getMainPage() {
        return "main";
    }


    @GetMapping("/oneAction")
    public String getImplOneAction()  {
        oneService.compareTwoLists();
        openFileFromOS.openFile(PathToFile.RESULT);
        return "main";
    }

    @GetMapping("/twoAction")
    public String getImplTwoAction()  {
        twoService.compareTwoLists();
        openFileFromOS.openFile(PathToFile.RESULT);
        return "main";
    }

    @GetMapping("/threeAction")
    public String getImplThreeAction()  {
        threeService.prepareListAsShape();
        openFileFromOS.openFile(PathToFile.RESULT);
        return "main";
    }

    @GetMapping("/fourAction")
    public String getImplFourAction()  {
       fourService.prepareListAsShape();
        openFileFromOS.openFile(PathToFile.RESULT);
        return "main";
    }

}
