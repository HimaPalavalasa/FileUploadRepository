package src.main.resources.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import src.main.resources.vo.DocumentMetaData;
import src.main.resources.vo.Document;

/**
 * 
 * @author HimaP
 *
 */
@Component
public class FileUploadBusinessServices implements FileBusinessServices {

	private static final Logger LOG = Logger.getLogger(FileUploadBusinessServices.class);

	@Autowired
	private DocumentDao documentDao;

	public DocumentMetaData save(Document documentVO) throws FileNotFoundException, IOException {
		documentDao.insert(documentVO);
		return documentVO.getMetadata();
	}

}
