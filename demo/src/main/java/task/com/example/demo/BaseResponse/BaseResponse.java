package task.com.example.demo.BaseResponse;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class BaseResponse<T> {
    @Builder.Default
    String StatusCode = "200";
    @Builder.Default
    String StatusMsg = "SUCCESS";
    private T Data;
}