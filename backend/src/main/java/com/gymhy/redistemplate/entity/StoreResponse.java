package com.gymhy.redistemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gongyiming
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponse {

    private boolean flag;

    private String oneTimeURL;
}
