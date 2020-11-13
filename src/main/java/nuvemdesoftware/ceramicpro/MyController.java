package nuvemdesoftware.ceramicpro;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home(Model model) {

        List words = Arrays.asList("mountain", "noon", "rock", "river", "spring");

        model.addAttribute("words", words);

        return "index";
    }
}