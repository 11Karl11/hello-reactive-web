package com.example.demo.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Elektra
 * Created on 2020-09-23 14:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnounceOperaDto implements Serializable {

    private Integer id;

    private Integer type;

    private Integer userId;
}