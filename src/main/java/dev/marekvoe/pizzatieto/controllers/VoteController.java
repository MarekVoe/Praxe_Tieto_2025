package dev.marekvoe.pizzatieto.controllers;

import dev.marekvoe.pizzatieto.models.Pizza;
import dev.marekvoe.pizzatieto.services.TokenService;
import dev.marekvoe.pizzatieto.services.VoteService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;
    private final TokenService tokenService;

    public VoteController(VoteService voteService, TokenService tokenService) {
        this.voteService = voteService;
        this.tokenService = tokenService;
    }

    @GetMapping("/generateToken")
    public String generateVoteToken() {
        String token = tokenService.generateToken();
        return token;
    }

    @PostMapping("/vote/{pizzaId}")
    public String voteForPizza(@PathVariable int pizzaId, @RequestHeader("Authorization") String token) {
        voteService.voteForPizza(pizzaId, token);
        return "Hlas byl úspěšně zaznamenán!";
    }

    @GetMapping("/getVotes/{pizzaId}")
    public int getVotesForPizza(@PathVariable int pizzaId) {
        return voteService.getVoteResults().get(pizzaId);
    }

    @GetMapping("/results")
    public Map<Integer, Integer> getVoteResults() {
        return voteService.getVoteResults();
    }
}