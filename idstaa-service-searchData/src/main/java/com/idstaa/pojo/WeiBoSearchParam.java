package com.idstaa.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenjie
 * @date 2021/1/7 14:49
 */
@Data
/**
 *containerid=100103type=1&q=
 */
public class WeiBoSearchParam implements Serializable {
    private String containerid;

    private String type;

    private String q;
}
