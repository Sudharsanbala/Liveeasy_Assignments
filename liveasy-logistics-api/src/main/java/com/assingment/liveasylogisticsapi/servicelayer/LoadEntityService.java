package com.assingment.liveasylogisticsapi.servicelayer;

import com.assingment.liveasylogisticsapi.entity.LoadEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoadEntityService {

    public LoadEntity saveLoadEntity(LoadEntity loadEntity);

    List<LoadEntity> fetchloadslist();

   public Optional<LoadEntity> fetchloadsbyId(Long loadId);

   public  LoadEntity fetchLoadsbyShipperId(UUID shipperid);

    void deleteByLoadId(Long loadId);

    LoadEntity updateLoadDetails(Long loadId, LoadEntity loadEntity);

    //LoadEntity getLoadEntityById(Long id);

    //List<LoadEntity> getAllLoadEntities();
    //void deleteLoadEntity(Long id);

    //List<LoadEntity> getLoadsByShipperId(String shipperId);

   // void updateLoadEntity(Long loadId, LoadEntity updatedLoad);
}
