package main.java.LLD.InventoryManagementSystem.models;

public class InventoryRequest {
    private String requestId;
    private String productId;
    private int quantity;
    private RequestType requestType;

    public InventoryRequest(String requestId, String productId, int quantity, RequestType requestType) {
        this.requestId = requestId;
        this.productId = productId;
        this.quantity = quantity;
        this.requestType = requestType;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    @Override
    public String toString() {
        return "InventoryRequest{" +
                "requestId='" + requestId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", requestType=" + requestType +
                '}';
    }
}
