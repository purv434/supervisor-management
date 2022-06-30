package com.supervisormanagement.service;

import com.supervisormanagement.dto.NotificationRequestDTO;
import com.supervisormanagement.dto.ResponseDTO;
import com.supervisormanagement.dto.SupervisorsDTO;
import com.supervisormanagement.utill.BaseMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";

    @Override
    public Object getAllSupervisors() {
        SupervisorsDTO[] supervisorsDTOList = restTemplate.getForObject(URL, SupervisorsDTO[].class);

        Function<SupervisorsDTO, String> byJurisdiction = SupervisorsDTO::getJurisdiction;
        Function<SupervisorsDTO, String> byFirstName = SupervisorsDTO::getFirstName;
        Function<SupervisorsDTO, String> byLastName = SupervisorsDTO::getLastName;

        Comparator<SupervisorsDTO> comparator =
                Comparator.comparing(byJurisdiction).thenComparing(byLastName).thenComparing(byFirstName);

        List<String> supervisors = Arrays.stream(supervisorsDTOList).
                sorted(comparator).
                filter(data -> !BaseMethod.isNumeric(data.getJurisdiction())).
                map(data -> {
                    return data.getJurisdiction() + "-" + data.getLastName() + "," + data.getFirstName();
                }).
                collect(Collectors.toList());

        return ResponseEntity.ok().body(new ResponseDTO("Supervisors Data Obtained successfully!!", HttpStatus.OK, supervisors));
    }

    @Override
    public Object createNotification(NotificationRequestDTO notificationRequestDTO) {
        System.out.println(notificationRequestDTO);
        return ResponseEntity.ok().body(new ResponseDTO("Notification created!!",HttpStatus.OK));
    }
}
