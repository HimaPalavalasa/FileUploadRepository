package src.main.resources.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import src.main.resources.vo.DocumentMetaDataVO;
import src.main.resources.vo.DocumentVO;

/**
 * 
 * @author HimaP
 *
 */
@Component
public class FileBusinessServices implements IFileBusinessServices {

	private static final Logger LOG = Logger.getLogger(FileBusinessServices.class);
	
	@Autowired
    private IDocumentDao documentDao;
	
	public DocumentMetaDataVO save(DocumentVO documentVO) throws FileNotFoundException, IOException {
		documentDao.insert(documentVO); 
        return documentVO.getMetadata();
	}

}
