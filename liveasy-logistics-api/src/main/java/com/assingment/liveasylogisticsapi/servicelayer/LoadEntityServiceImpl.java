package com.assingment.liveasylogisticsapi.servicelayer;


import com.assingment.liveasylogisticsapi.Repository.LoadRepository;
import com.assingment.liveasylogisticsapi.entity.LoadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadEntityServiceImpl implements LoadEntityService {

    @Autowired
    private LoadRepository loadRepository;

    @Autowired
    public LoadEntityServiceImpl (LoadRepository loadRepository){
        this.loadRepository=loadRepository;
    }

    @Override
    @Transactional
    public LoadEntity saveLoadEntity(LoadEntity loadEntity) {
        UUID uuid=UUID.randomUUID();
        loadEntity.setShipperId(uuid);
        return loadRepository.save(loadEntity);
    }

    @Override
    public List<LoadEntity> fetchloadslist() {
        return loadRepository.findAll();
    }

    @Override
    public Optional<LoadEntity> fetchloadsbyId(Long loadId) {
        return Optional.of(loadRepository.findById(loadId).get());
    }

    @Override
    public  LoadEntity fetchLoadsbyShipperId(UUID shipperid) {
        return loadRepository.findByShipperId(shipperid).get();
    }

    @Override
    public void deleteByLoadId(Long loadId) {
        loadRepository.deleteById(loadId);
    }

    @Override
    public LoadEntity updateLoadDetails(Long loadId, LoadEntity loadEntity) {
       LoadEntity loadDB=loadRepository.findById(loadId).get();
       if(Objects.nonNull(loadEntity.getLoadingPoint())&&
        !"".equalsIgnoreCase(loadEntity.getLoadingPoint())) {
           loadDB.setLoadingPoint(loadEntity.getLoadingPoint());
       }

       if(Objects.nonNull(loadEntity.getUnloadingPoint())&&
               !"".equalsIgnoreCase(loadEntity.getUnloadingPoint())) {
           loadDB.setUnloadingPoint(loadEntity.getUnloadingPoint());
       }

        if(Objects.nonNull(loadEntity.getProductType())&&
                !"".equalsIgnoreCase(loadEntity.getProductType())){
            loadDB.setProductType(loadEntity.getProductType());}

        if(Objects.nonNull(loadEntity.getDate())&&
                !"".equalsIgnoreCase(String.valueOf(loadEntity.getDate()))){
            loadDB.setDate(loadEntity.getDate());}

        if(Objects.nonNull(loadEntity.getNoOfTrucks())&&
                !"".equalsIgnoreCase(String.valueOf(loadEntity.getNoOfTrucks()))){
            loadDB.setNoOfTrucks(loadEntity.getNoOfTrucks());}

        //if(Objects.nonNull(loadEntity.getShipperId())&&
               // !"".equalsIgnoreCase(String.valueOf(loadEntity.getShipperId()))){
            //loadDB.setShipperId(loadEntity.getShipperId());}


        if(Objects.nonNull(loadEntity.getWeight())&&
                !"".equalsIgnoreCase(String.valueOf(loadEntity.getWeight()))){
            loadDB.setWeight(loadEntity.getWeight());}

        if(Objects.nonNull(loadEntity.getTruckType())&&
                !"".equalsIgnoreCase(String.valueOf(loadEntity.getTruckType())))
        loadDB.setTruckType(loadEntity.getTruckType());

        if(Objects.nonNull(loadEntity.getOptionalComment())&&
                !"".equalsIgnoreCase(String.valueOf(loadEntity.getOptionalComment()))){
            loadDB.setOptionalComment(loadEntity.getOptionalComment());}






        return loadRepository.save(loadDB);











        }

    }



