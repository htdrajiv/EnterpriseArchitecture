package com.cuisine_mart.schedule;

import com.cuisine_mart.user.domain.Person;
import com.cuisine_mart.user.service.IServiceContract.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Rajiv on 9/1/2016.
 */
@Component
@EnableScheduling
@RestController
public class ScheduleJobs {
    @Autowired
    IPersonService personService;

    @RequestMapping("/getReport")
    public @ResponseBody List<Person> prepareRpt(){
        return prepareReport();
    }

    @Scheduled(cron="0 0 12 30 * *")
    public List<Person> prepareReport(){
        List<Person> persons = personService.getReportForPersonByLocations();
        return persons;
    }
}
