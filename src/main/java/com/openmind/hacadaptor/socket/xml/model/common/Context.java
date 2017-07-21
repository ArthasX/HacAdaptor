package com.openmind.hacadaptor.socket.xml.model.common;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by LiuBin on 2017/7/3.
 */
@XmlTransient
public abstract class Context<T> implements IContext<T>{
    public T getContextDetail(){
        return null;
    }
}
