package com.bioimage.archive.demo.service;

import com.bioimage.archive.demo.BioImageArchiveApplication;
import com.bioimage.archive.demo.model.Image;
import com.bioimage.archive.demo.model.ImageSizeResponseObject;
import com.bioimage.archive.demo.repository.ImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageService {
    private static final Logger logger = LoggerFactory.getLogger(BioImageArchiveApplication.class);
    @Autowired
    ImageRepository imageRepository;


    /**
     * This method return list of accession id present in the database.
     * @return List of string containing accession id
     */
    public List<String> getAccessionId(){
        List<String> AccessionIdList = imageRepository.findAll().stream()
                .map(image -> image.getAccessionId())
                .collect(Collectors.toList());
        if(AccessionIdList.isEmpty()){
            logger.error("No Metadata available");
        }else {
            logger.info("Accession Id's are" + AccessionIdList.toString());
        }
        return AccessionIdList;
    }

    /**
     * This method takes AccessionId as input parameter and returns finds
     * related images meta data from the database.
     * @param AccessionId
     * @return returns a image object
     */
    public Image getImageMetadataById(String AccessionId){
        Optional<Image> metadata = Optional.of(new Image());
        try{
            logger.info("Request received for retrieving meta data for "+ AccessionId);
            metadata = Optional.ofNullable(imageRepository.findByAccessionId(AccessionId));
            if(metadata.isPresent()){
                logger.info("Information retrieved successfully "+ metadata.toString());
            }else{
                logger.info("No Information present for the Id "+ AccessionId);
            }

        }catch (Exception e){
            logger.error("Error getting Metadata for the Id " + AccessionId);
            e.printStackTrace();

        }
        return metadata.get();

    }

    /**
     * This method takes AccessionId and retrieves metadata for the id and calculates images size
     * image size is calculated using product of dimensions and voxel size
     * @param AccessionId
     * @return
     */
    public ImageSizeResponseObject calculateImageSizeInformation(String AccessionId){
        ImageSizeResponseObject responseObject = new ImageSizeResponseObject();
        logger.info("Request for imagesize for id "+ AccessionId + "Received");
        try{
            Optional<Image> imageMetadata = Optional.ofNullable(imageRepository.findByAccessionId(AccessionId));
            if(imageMetadata.isPresent()){
                int length = imageMetadata.get().getDimensions().length();
                String dimensions[] = imageMetadata.get().getDimensions().substring(1, length-1).split(",");


                int dimensionsProduct = 1;
                for(String i: dimensions){
                    dimensionsProduct *= Integer.valueOf(i.trim());
                }
                responseObject.setAccessionId(imageMetadata.get().getAccessionId());
                responseObject.setDimensions(imageMetadata.get().getDimensions());
                responseObject.setVoxelSizeBytes(imageMetadata.get().getVoxelSizeBytes());
                responseObject.setImageSize(dimensionsProduct*imageMetadata.get().getVoxelSizeBytes());
                logger.info("Image size information is parsed " + responseObject.toString());
            }else{
                logger.info("No Image metadata present for the Id "+AccessionId);
            }

        }catch (Exception e){
            logger.error("Error calculating image size for the id " +AccessionId);
            e.printStackTrace();
        }


        return responseObject;

    }
}
