package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleUser {

    private Long roleId;

    private String roleName;
    /**
     * 描述
     */
    private String roleDesc;

    private Integer showOrder;
    /**
     * 0失效  1在用
     */
    private Integer status;

    private Integer flag;
}
