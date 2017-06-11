
package su.vistar.tryasometrdatatransfer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import su.vistar.tryasometrdatatransfer.mapper.DataMapper;
//import su.vistar.tryasometrdatatransfer.mapper.TryasometrMapper;
//import su.vistar.tryasometrdatatransfer.model.Acceleration;
//import su.vistar.tryasometrdatatransfer.model.Location;
import su.vistar.tryasometrdatatransfer.model.ResponseEntity;
//import su.vistar.tryasometrdatatransfer.model.Info;
import su.vistar.tryasometrdatatransfer.model.PitDto;
import su.vistar.tryasometrdatatransfer.model.Section;
import su.vistar.tryasometrdatatransfer.service.PathService;
import su.vistar.tryasometrdatatransfer.service.SectionUpdateService;


@Controller
public class ApiController {
    
    /*@Autowired
    DataMapper dataMapper;*/
    
    @Autowired
    SectionUpdateService sectionUpdateService;
    
    @Autowired
    PathService pathService;
    
    /*@GetMapping(value = "/start")
    public ModelAndView loadingobjectmanagerPage() {
        ModelAndView model = new ModelAndView("view");
        return model;
    }*/
    
    /*@PostMapping(value = "/save_location/")
    @ResponseBody
    public ResponseEntity saveLocations(@RequestBody List<Location> list) {
        if (!list.isEmpty())
            dataMapper.insertListOfLocations(list);
        return new ResponseEntity("OK");
    }*/

    /*@PostMapping(value = "/save_acceleration/")
    @ResponseBody
    public ResponseEntity saveAccelerations(@RequestBody List<Acceleration> list) {
        if (!list.isEmpty())
            dataMapper.insertListOfAcceleration(list);
        return new ResponseEntity("OK");
    }*/
    
    /*@PostMapping(value = "/save_info_objects/")
    @ResponseBody
    public ResponseEntity saveInfoObjects(@RequestBody List<Info> list){
         if (!list.isEmpty())
             dataMapper.insertListOfInfoObjects(list);
         return new ResponseEntity("OK");
    }*/
    
    @PostMapping(value = "/mark_pit_interval/")
    @ResponseBody
    public ResponseEntity savePitInterval(@RequestBody PitDto pit){
        //PitDto _pit = pit;
        List<Section> sections = pathService.getSectionsIntoRectangle(
                new Double[]{pit.getLat1(), pit.getLon1()},
                new Double[]{pit.getLat2(), pit.getLon2()}
        );
        sectionUpdateService.updateSectionValues(sections, pit);
        return new ResponseEntity("OK");
    }
    
}
