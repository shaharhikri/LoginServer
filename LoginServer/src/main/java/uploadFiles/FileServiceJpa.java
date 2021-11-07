package uploadFiles;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

import errors.FileDidntUploadException;

@Service
public class FileServiceJpa implements FileService {

	@Override
	public String uploadFile(MultipartFile files[], String upload_user_directory) throws IOException, FileDidntUploadException {
		Path path;
		String fileNames="";
		for (MultipartFile file : files) {
			if(file.isEmpty()) 
				throw new FileDidntUploadException();

			path = Paths.get(upload_user_directory, file.getOriginalFilename());
			try {
				Files.write(path, file.getBytes());
			}
			catch(java.nio.file.NoSuchFileException e) {
				new File(upload_user_directory).mkdirs();
				Files.write(path, file.getBytes());
			}
			
			fileNames+=file.getOriginalFilename();
			fileNames+="  ";
		}
		return fileNames;
	}

	@Override
	public String[] getAllFileNames(String upload_user_directory) throws FileDidntUploadException {
		File dir = new File(upload_user_directory);
		if(!dir.exists())
			throw new FileDidntUploadException();
		return dir.list();
	}
}
