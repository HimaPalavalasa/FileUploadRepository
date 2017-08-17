package src.main.resources.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.main.resources.vo.DocumentMetaData;
import src.main.resources.vo.Document;

/**
 * 
 * @author HimaP
 *
 */
public interface FileBusinessServices {
	DocumentMetaData save(Document documentVO) throws FileNotFoundException, IOException;
}
