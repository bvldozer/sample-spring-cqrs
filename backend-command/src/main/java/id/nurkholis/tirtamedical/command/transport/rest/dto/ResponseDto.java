package id.nurkholis.tirtamedical.command.transport.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {
    private T data;
    private Pagedata paging;
    private Object errors;

    public static <T> ResponseDto<T> ok(T data) {
        ResponseDto<T> response = new ResponseDto<>();
        response.setData(data);
        return response;
    }

    public static <T> ResponseDto<T> ok(T data, Pagedata paging) {
        ResponseDto<T> response = new ResponseDto<>();
        response.setData(data);
        response.setPaging(paging);
        return response;
    }

    public static <T> ResponseDto<T> error(Object errors) {
        ResponseDto<T> response = new ResponseDto<>();
        response.setErrors(errors);
        return response;
    }

    @Getter
    @Setter
    public static class Pagedata {

        private int total = 0;
        private int current = 1;
        private int size = 1;

        public Pagedata(int total, int current, int size) {
            this.total = total;
            this.current = current;
            this.size = size;
        }

    }

    /*@Getter
    @Setter
    @AllArgsConstructor
    public static class Error {

        private String code;
        private String message;
        private String field;

        public Error(Error valErr) {
            this.code = valErr.getCode();
            this.message = valErr.getMessage();
            this.field = valErr.getField();
        }
    }*/
}
