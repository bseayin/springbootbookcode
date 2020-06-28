package com.xsz.excetion;

/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/9/2$ 21:47$
 */
public class UserNotExistException extends RuntimeException{
    private static final long serialVersionUID = -1574716826948451793L;

    private String id;

    public UserNotExistException(String id){
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
