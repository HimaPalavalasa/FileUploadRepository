package src.main.resources.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import src.main.resources.vo.DocumentVO;
import src.main.resources.vo.DocumentMetaDataVO;

/**
 * 
 * @author HimaP
 *
 */
@RestController
public class FileUploadRestController {
	
	private static final Logger LOG = Logger.getLogger(FileUploadRestController.class);
	
	@Autowired
	IFileBusinessServices fileBusinessServices;
	
	public IFileBusinessServices getFileBusinessServices() {
		return fileBusinessServices;
	}

	public void setFileBusinessServices(IFileBusinessServices fileBusinessServices) {
		this.fileBusinessServices = fileBusinessServices;
	}

	@RequestMapping(value="/uploadFile",method = RequestMethod.POST)
    public @ResponseBody DocumentMetaDataVO uploadFile(@RequestParam(value="file", required=true) MultipartFile file,
    		@RequestParam(value="itemName", required=true) String itemName,
            @RequestParam(value="itemType", required=true) String itemType) throws IOException {
		
    	DocumentVO documentVO = null;
		try {
			
			documentVO = new DocumentVO(file.getBytes(), file.getOriginalFilename(), itemName, itemType );
			getFileBusinessServices().save(documentVO);
			
		} catch (IOException e) {
			LOG.error("IOException in uploadFile ",e);
			throw e;
		}catch (Exception e) {
			LOG.error("Exception in uploadFile ",e);
			throw e;
		}
		
    	return documentVO.getMetadata();
    }
}
