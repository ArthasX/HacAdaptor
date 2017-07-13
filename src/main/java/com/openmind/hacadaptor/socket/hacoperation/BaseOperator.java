package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;

/**
 * The base operator class to get xmldto.
 * <p>I think it's redundant,however,i decided to keep it.
 * <p>Created by LiuBin on 2017/7/6.
 */
public abstract class BaseOperator implements IOperator {
    protected XMLDTO xmldto;

    @Override
    public abstract XMLDTO getXmldtoBack();
}
