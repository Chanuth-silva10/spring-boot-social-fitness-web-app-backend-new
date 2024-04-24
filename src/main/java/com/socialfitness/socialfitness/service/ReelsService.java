package com.socialfitness.socialfitness.service;

import com.socialfitness.socialfitness.models.Reels;
import com.socialfitness.socialfitness.models.User;

import java.util.List;

public interface ReelsService {

    public Reels createReel(Reels reels, User user);
    public List<Reels> findAllReels();
    public List<Reels> findUsersReel(Integer userId) throws Exception;
}
