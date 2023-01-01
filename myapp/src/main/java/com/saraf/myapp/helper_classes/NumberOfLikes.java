package com.saraf.myapp.helper_classes;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NumberOfLikes {
    private long id;
    private int numberOfLikes;


}
