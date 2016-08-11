package com.ryosms.model;


import io.searchbox.annotations.JestId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ryosms on 2016/08/12.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @JestId
    private String id;

    private String name;

    private String email;

}
