package net.storyshelf.ms_writer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpResponse<T> {
    private int status;
    private String message;
    private T data;
}
