package request.response.example;

public interface RequestHandler<TRequest extends RequestData<TResponse>, TResponse extends ResponseData> {

	TResponse processRequest(TRequest request);

}
