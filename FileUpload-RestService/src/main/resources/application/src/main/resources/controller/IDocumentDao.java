package src.main.resources.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.main.resources.vo.DocumentVO;

/**
 * 
 * @author HimaP
 *
 */
public interface IDocumentDao {
	public void insert(DocumentVO documentVO) throws FileNotFoundException, IOException;
}
