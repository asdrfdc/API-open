package com.zm.apicommon.service;



/**
* @author 29524
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-05-18 09:48:26
*/
public interface InnerUserInterfaceInfoService {




    /**
     * 调用接口统计
     *
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

}
