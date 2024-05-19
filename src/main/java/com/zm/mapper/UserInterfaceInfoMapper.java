package com.zm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zm.apicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author 29524
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2024-05-18 09:48:26
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    //select interface_info_id,sum(total_num) as totalNum from user_interface_info group by interface_info_id order by total_num desc limit 3
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




