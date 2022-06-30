package com.supervisormanagement.controller;


import com.supervisormanagement.dto.NotificationRequestDTO;
import com.supervisormanagement.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;


    @GetMapping("/supervisors")
    public Object getAllSupervisors(){
        return supervisorService.getAllSupervisors();
    }

    @PostMapping("/submit")
    public Object createNotification(@Valid @RequestBody NotificationRequestDTO notificationRequestDTO){
        return supervisorService.createNotification(notificationRequestDTO);
    }
}
