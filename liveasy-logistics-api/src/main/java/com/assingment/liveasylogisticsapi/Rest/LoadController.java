package com.assingment.liveasylogisticsapi.Rest;

import com.assingment.liveasylogisticsapi.entity.LoadEntity;
import com.assingment.liveasylogisticsapi.servicelayer.LoadEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController

public class LoadController {

    @Autowired
    private  LoadEntityService loadEntityService;

    @Autowired
    public LoadController(LoadEntityService loadEntityService) {
        this.loadEntityService = loadEntityService;
    }



    @PostMapping("/addLoad")
    public ResponseEntity<String> createLoad(@RequestBody LoadEntity loadEntity) {
         loadEntityService.saveLoadEntity(loadEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Load details added successfully");
    }

    @GetMapping("/getLoad")
    public  List<LoadEntity> fetchloadslist(){
        return loadEntityService.fetchloadslist();
    }

    @GetMapping("/getLoad/{id}")
    public Optional<LoadEntity> fetchloadsbyId(@PathVariable("id") Long loadId){
        return loadEntityService.fetchloadsbyId(loadId);

    }

    @GetMapping("/getLoadbyshipperId/{shipperId}")
    public LoadEntity fetchLoadsbyShipperId(@PathVariable("shipperId") UUID shipperid){
         return loadEntityService.fetchLoadsbyShipperId(shipperid);
         //return ResponseEntity.status(HttpStatus.CREATED).body("list of loads with this shipperId");
    }

    @DeleteMapping("/deleteLoad/{id}")
    public String deleteByLoadId(@PathVariable("id") Long loadId){
        loadEntityService.deleteByLoadId(loadId);
        return "Load Details deleted sucessfully";

    }

    @PutMapping("/updateLoad/{id}")
    public LoadEntity updateLoadDetails(@PathVariable("id") Long loadId,@RequestBody LoadEntity loadEntity){
        return loadEntityService.updateLoadDetails(loadId,loadEntity);


    }








}
