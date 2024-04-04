package exception;

public enum ErrorCode {
	
    INTERNAL_SERVER_ERROR(500), NOT_FOUND(404), FORBIDDEN(403), BAD_REQUEST(400),
    UNAUTHORIZED(401), METHOD_NOT_SUPPORTED(405), INVALID_OPERATION(412), 
    CONFLICT(409);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}



