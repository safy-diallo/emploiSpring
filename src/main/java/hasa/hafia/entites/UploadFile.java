package hasa.hafia.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.web.multipart.support.MultipartFilter;

@Entity
public class UploadFile {
	@Id
	@GeneratedValue()
	
	private String description;
	 
    // Upload files.
    private MultipartFilter[] fileDatas;
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public MultipartFilter[] getFileDatas() {
        return fileDatas;
    }
 
    public void setFileDatas(MultipartFilter[] fileDatas) {
        this.fileDatas = fileDatas;
    }
}
