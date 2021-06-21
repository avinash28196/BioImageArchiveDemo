package com.bioimage.archive.demo.model;


import javax.persistence.*;

@Entity
@Table(name="Images")
public class Image {
    @Id
    @Column(name="AccessionID")
    private String accessionId;
    private String author;
    private String species;
    private String tissue;
    @Column(name="Voxel_Size_Bytes")
    private int voxelSizeBytes;
    private String dimensions;

    public String getAccessionId() {
        return accessionId;
    }

    public void setAccessionId(String accessionId) {
        this.accessionId = accessionId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getTissue() {
        return tissue;
    }

    public void setTissue(String tissue) {
        this.tissue = tissue;
    }

    public int getVoxelSizeBytes() {
        return voxelSizeBytes;
    }

    public void setVoxelSizeBytes(int voxelSizeBytes) {
        this.voxelSizeBytes = voxelSizeBytes;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "Image{" +
                "accessionId='" + accessionId + '\'' +
                ", author='" + author + '\'' +
                ", species='" + species + '\'' +
                ", tissue='" + tissue + '\'' +
                ", voxelSizeBytes=" + voxelSizeBytes +
                ", dimensions='" + dimensions + '\'' +
                '}';
    }
}
