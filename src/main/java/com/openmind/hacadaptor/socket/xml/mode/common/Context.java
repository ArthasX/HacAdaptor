package com.openmind.hacadaptor.socket.xml.mode.common;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by KJB-001064 on 2017/7/3.
 */
@XmlTransient
public abstract class Context<T> implements IContext<T>{
    public T getContextDetail(){
        return null;
    }
}
