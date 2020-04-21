package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleMenu {

    /**
     * 主键Id
     */
    private Long menuId;

    //菜单名称
    private String title;

    //是否展开
    private Boolean expand;

    //是否选中
    private Boolean checked;

    private Integer flag;
    /**
     * 菜单的父id
     */
    private Long pid;
    //显示顺序
    private Integer showOrder;

    private List<RoleMenu> children;
}
