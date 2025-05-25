package dev.marekvoe.pizzatieto.controllers;

import dev.marekvoe.pizzatieto.models.Pizza;
import dev.marekvoe.pizzatieto.services.VoteService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/vote/{pizzaId}")
    public String voteForPizza(@PathVariable int pizzaId) {
        voteService.voteForPizza(pizzaId);
        return "Hlas byl úspěšně zaznamenán!";
    }

    @GetMapping("/results")
    public Map<Integer, Integer> getVoteResults() {
        return voteService.getVoteResults();
    }
}