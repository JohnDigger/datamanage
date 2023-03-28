package com.datamanage.datamanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 贾佳
 * @date 2023/3/29 1:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestEntity {
    private List<InShopEntity> inShopEntities;
}
