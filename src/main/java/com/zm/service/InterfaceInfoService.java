package com.zm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zm.apicommon.model.entity.InterfaceInfo;

/**
* @author 29524
* @description 针对表【interface_info(接口信息)】的数据库操作Service
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add 是否为创建校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
