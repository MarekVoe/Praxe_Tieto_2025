package dev.marekvoe.pizzatieto.controllers;

import dev.marekvoe.pizzatieto.models.Pizza;
import dev.marekvoe.pizzatieto.services.TokenService;
import dev.marekvoe.pizzatieto.services.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.rmi.server.LogStream.log;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private static final Logger log = LoggerFactory.getLogger(VoteController.class);
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
        System.out.println("Vote Controller Token: " + token);
        voteService.voteForPizza(pizzaId, token);
        return "Hlas byl úspěšně zaznamenán!";
    }

    @PostMapping("/unvote/{pizzaId}")
    public String unvoteForPizza(@PathVariable int pizzaId, @RequestHeader("Authorization") String token) {
        voteService.unvoteForPizza(pizzaId, token);
        return "Hlas byl úspěšně zrušen!";
    }

    @GetMapping("/getVotes/{pizzaId}")
    public int getVotesForPizza(@PathVariable int pizzaId) {
        return voteService.getVoteResults().getOrDefault(pizzaId, 0);
    }

    @GetMapping("/results")
    public Map<Integer, Integer> getVoteResults() {
        return voteService.getVoteResults();
    }
}