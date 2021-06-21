package com.bioimage.archive.demo.repository;

import com.bioimage.archive.demo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findAllByAccessionId(String Id);

    @Query(value = "select 1 from Image", nativeQuery = true)
    List<Image> getDistinctTopByAccessionId();

    Image findByAccessionId(String Id);
}
