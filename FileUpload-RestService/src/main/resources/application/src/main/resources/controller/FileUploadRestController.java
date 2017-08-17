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

import src.main.resources.vo.Document;
import src.main.resources.vo.DocumentMetaData;

/**
 * 
 * @author HimaP
 *
 */
@RestController
public class FileUploadRestController {

	private static final Logger LOG = Logger.getLogger(FileUploadRestController.class);

	@Autowired
	FileBusinessServices fileBusinessServices;

	public FileBusinessServices getFileBusinessServices() {
		return fileBusinessServices;
	}

	public void setFileBusinessServices(FileBusinessServices fileBusinessServices) {
		this.fileBusinessServices = fileBusinessServices;
	}

	/**
	 * This POST service take file, itemName and itemType as input and uploads to a
	 * directory. URL : /uploadFile?file={file}&itemName={itemName}&itemType={itemType}
	 * 
	 * @param file
	 * @param itemName
	 * @param itemType
	 * @return DocumentMetaData
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody DocumentMetaData uploadFile(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = "itemName", required = true) String itemName,
			@RequestParam(value = "itemType", required = true) String itemType) throws IOException {

		Document documentVO = null;
		try {

			documentVO = new Document(file.getBytes(), file.getOriginalFilename(), itemName, itemType);
			getFileBusinessServices().save(documentVO);

		} catch (IOException e) {
			LOG.error("IOException in uploadFile ", e);
			throw e;
		} catch (Exception e) {
			LOG.error("Exception in uploadFile ", e);
			throw e;
		}

		return documentVO.getMetadata();
	}
}
