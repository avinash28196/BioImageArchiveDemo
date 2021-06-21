package com.bioimage.archive.demo.model;

public class ImageSizeResponseObject {

    private String accessionId;
    private int voxelSizeBytes;
    private String dimensions;
    private int imageSize;

    public String getAccessionId() {
        return accessionId;
    }

    public void setAccessionId(String accessionId) {
        this.accessionId = accessionId;
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

    public int getImageSize() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    @Override
    public String toString() {
        return "ImageSizeResponseObject{" +
                "accessionId='" + accessionId + '\'' +
                ", voxelSizeBytes=" + voxelSizeBytes +
                ", dimensions='" + dimensions + '\'' +
                ", imageSize=" + imageSize +
                '}';
    }
}
