package com.example.fileupload;

public class Upload {
    private String uploadName;
    private String uploadImageUrl;

    public Upload(){
        //default
    }

    public Upload(String name, String imageUrl){
        if(name.trim().equals("")){
            name = "No name";
        }
        uploadName = name;
        uploadImageUrl = imageUrl;
    }

    public String getUploadName(){
        return uploadName;
    }

    public void setUploadName(String name){
        uploadName = name;
    }

    public String getUploadImageUrl(){
        return uploadImageUrl;
    }

    public void setUploadImageUrl(String imageUrl){
        uploadImageUrl = imageUrl;
    }

}
