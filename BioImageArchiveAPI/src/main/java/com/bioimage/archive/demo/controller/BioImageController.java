package com.bioimage.archive.demo.controller;

import com.bioimage.archive.demo.model.Image;
import com.bioimage.archive.demo.model.ImageSizeResponseObject;
import com.bioimage.archive.demo.repository.ImageRepository;
import com.bioimage.archive.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BioImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageRepository imageRepository;

    @RequestMapping(value = "/")
    public String sayHello(){
        return "Aloha";
    }

    @RequestMapping(path = "/images")
    public List<String> getAllAccessionId(){
        return imageService.getAccessionId();
    }

    @RequestMapping(path="/accessions/{accessionID}/metadata")
    public Image getImageMetaData(@PathVariable String accessionID){

        return imageService.getImageMetadataById(accessionID);
    }

    @RequestMapping(path="/accessions/{accessionID}/imagesize")
    public ImageSizeResponseObject getImageSizeInformation(@PathVariable String accessionID){
        return imageService.calculateImageSizeInformation(accessionID);
    }

    @RequestMapping(path = "/metadata")
    public List<Image> getImages(){
        return imageRepository.findAll();
    }

}
