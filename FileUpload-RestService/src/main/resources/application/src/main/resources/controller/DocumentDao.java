package src.main.resources.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.main.resources.vo.Document;

/**
 * 
 * @author HimaP
 *
 */
public interface DocumentDao {
	public void insert(Document documentVO) throws FileNotFoundException, IOException;
}
