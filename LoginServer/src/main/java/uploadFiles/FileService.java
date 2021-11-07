package uploadFiles;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

import errors.FileDidntUploadException;

public interface FileService {
	public String uploadFile(MultipartFile file[], String upload_user_directory) throws IOException, FileDidntUploadException ;
	public String[] getAllFileNames(String upload_user_directory) throws FileDidntUploadException;
}
