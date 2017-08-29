package com.openmind.hacadaptor.controller;

import com.alibaba.fastjson.JSONObject;
import com.openmind.hacadaptor.model.Result;

/**
 * Created by LiuBin on 2017/6/22.
 */

public interface IBaseController {
    Result getAll();

    Result getById(String id);

    Result update(long id, JSONObject object);

    Result insert(JSONObject object);
}
