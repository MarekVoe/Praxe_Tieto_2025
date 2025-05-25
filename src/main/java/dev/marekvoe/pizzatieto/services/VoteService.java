package dev.marekvoe.pizzatieto.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoteService {

    private final Map<Integer, Integer> votes = new HashMap<>();

    public void voteForPizza(int pizzaId) {
        votes.put(pizzaId, votes.getOrDefault(pizzaId, 0) + 1);
    }

    public Map<Integer, Integer> getVoteResults() {
        return new HashMap<>(votes);
    }
}