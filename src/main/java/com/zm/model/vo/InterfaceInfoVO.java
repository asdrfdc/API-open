package com.zm.model.vo;

import com.zm.apicommon.model.entity.InterfaceInfo;
import lombok.Data;

import java.io.Serializable;


/**
 * 接口信息封装类
 */
@Data
public class InterfaceInfoVO extends InterfaceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总调用次数
     */
    private Integer totalNum;
}
