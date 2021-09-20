package task.com.example.demo.BaseResponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@ToString
public class PageResponse<T> extends SuccessResponse {
    private long totalRecordCount;
    boolean hasNext;
    boolean hasPrevious;
    private T data;
}


