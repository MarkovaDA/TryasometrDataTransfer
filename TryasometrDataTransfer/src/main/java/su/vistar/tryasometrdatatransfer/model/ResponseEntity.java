package su.vistar.tryasometrdatatransfer.model;

/**
 *
 * @author darya
 */
public class ResponseEntity {
    private String status;

    public ResponseEntity(String status) {
        this.status = status;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    public ResponseEntity(){} 
    
}
