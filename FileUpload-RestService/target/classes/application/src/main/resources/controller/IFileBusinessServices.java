package src.main.resources.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.main.resources.vo.DocumentMetaDataVO;
import src.main.resources.vo.DocumentVO;

/**
 * 
 * @author HimaP
 *
 */
public interface IFileBusinessServices {
	DocumentMetaDataVO save(DocumentVO documentVO) throws FileNotFoundException, IOException;
}
