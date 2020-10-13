package org.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 交易表
 *
 * @author Lch on 2020/9/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment  implements Serializable {
    private  Long id;
    private  String serial;
}