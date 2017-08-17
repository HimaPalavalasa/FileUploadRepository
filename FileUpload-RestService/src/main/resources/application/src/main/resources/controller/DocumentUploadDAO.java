package src.main.resources.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import src.main.resources.vo.Document;

/**
 * 
 * @author HimaP
 *
 */
@Service("documentDao")
public class DocumentUploadDAO implements DocumentDao {

	private static final Logger LOG = Logger.getLogger(DocumentUploadDAO.class);

	public void insert(Document documentVO) throws FileNotFoundException, IOException {
		createDirectory(documentVO);
		saveFileData(documentVO);
	}

	private void saveFileData(Document documentVO) throws FileNotFoundException, IOException {
		String path = getDirectoryPath(documentVO);
		BufferedOutputStream stream;
		try {
			stream = new BufferedOutputStream(new FileOutputStream(new File(new File(path), documentVO.getFileName())));
			stream.write(documentVO.getFileData());
			stream.write(documentVO.getMetadata().toString().getBytes());
			stream.close();
		} catch (FileNotFoundException e) {
			LOG.error("FileNotFoundException in saveFileData()", e);
			throw e;
		} catch (IOException e) {
			LOG.error("IOException in saveFileData()", e);
			throw e;
		}
	}

	private String getDirectoryPath(Document documentVO) {
		StringBuilder sb = new StringBuilder();
		sb.append("FileAssignment").append(File.separator).append(documentVO.getUuid());
		return sb.toString();
	}

	private void createDirectory(Document documentVO) {
		File file = new File(getDirectoryPath(documentVO));
		file.mkdirs();
	}
}
