package Model;

public class Response {
    
    private boolean Ok;
    private Object Message;

    public Response(boolean Ok, Object Message) {
        this.Ok = Ok;
        this.Message = Message;
    }

    public boolean isOk() {
        return Ok;
    }

    public Object getMessage() {
        return Message;
    }
    
}
