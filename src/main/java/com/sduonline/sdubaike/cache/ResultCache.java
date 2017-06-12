package com.sduonline.sdubaike.cache;

import com.sduonline.sdubaike.base.Result;

import static com.sduonline.sdubaike.base.ResultStatusValues.V_OK;
import static com.sduonline.sdubaike.base.ResultStatusMessage.*;
import static com.sduonline.sdubaike.base.ResultStatusValues.*;

public class ResultCache {
    public static final Result OK = new Result(V_OK,M_OK);
    public static final Result FAILURE = new Result(V_FAILURE,M_FAILURE);
    public static final Result PERMISSION_DENIED = new Result(V_PERMISSION_DENIED,M_PERMISSION_DENIED);
    public static Result getCache(int type) {
        if(type == 0)return FAILURE;
        if(type == 1)return OK;
        if(type == 3)return PERMISSION_DENIED;
        return null;
    }
    public static Result getDataOk(Object object){
        Result result = new Result(V_OK,M_OK);
        result.setData(object);
        return result;
    }
    public static Result getDataFailure(String errorMessage){
        Result result = new Result(V_FAILURE,M_FAILURE);
        result.setData(errorMessage);
        return result;
    }
}
