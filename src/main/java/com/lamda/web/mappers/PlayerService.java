package com.lamda.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired PlayerRepository playerRepository;
}
