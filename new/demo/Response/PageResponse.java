package task.com.example.demo.Response;

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
    public T data;
}


