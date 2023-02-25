package domain;

import com.sun.istack.NotNull;

import java.time.LocalDateTime;

public class BasicEntity {
    @NotNull
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
