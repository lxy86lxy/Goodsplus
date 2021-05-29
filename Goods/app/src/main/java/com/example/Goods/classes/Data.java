package com.example.Goods.classes;

public class Data {
    String []userIds=new String[200];
    String []userPasswords=new String[200];
    int size1=1;
    int size2=1;
    public void Data(String name,String id){
        userIds[0]=name;
        userPasswords[0]=id;

    }
    public void register(String userId,String passWord){
        userIds[size1++]=userId;
        userPasswords[size2++]=passWord;
    }
    public boolean login(String userId,String password){
        for (int i = 0; i <size1 ; i++) {
            if(userIds[i].equals(userId)){
                return true;
            }
        }return false;
    }
    private Data (){}
    private static Data instance;
    public static Data getInstance(){
        if(instance==null){
            instance=new Data();
        }
        return instance;
    }
}

