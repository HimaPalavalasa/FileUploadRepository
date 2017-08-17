package src.main.resources.vo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 
 * @author HimaP
 *
 */
public class Document extends DocumentMetaData implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2201415861401811259L;
	private byte[] fileData;

	public Document(byte[] fileData, String fileName, String itemName, String itemType) {
		super(fileName, itemName, itemType);
		this.fileData = fileData;
	}

	public DocumentMetaData getMetadata() {
		return new DocumentMetaData(getUuid(), getFileName(), getItemName(), getItemType());
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "DocumentVO [fileData=" + Arrays.toString(fileData) + ", uuid=" + uuid + ", fileName=" + fileName
				+ ", itemName=" + itemName + ", itemType=" + itemType + ", getMetadata()=" + getMetadata()
				+ ", getFileData()=" + Arrays.toString(getFileData()) + ", getUuid()=" + getUuid() + ", getFileName()="
				+ getFileName() + ", getItemName()=" + getItemName() + ", getItemType()=" + getItemType()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
