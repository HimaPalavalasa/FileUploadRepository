package src.main.resources.vo;

import java.io.Serializable;
import java.util.UUID;

public class DocumentMetaDataVO implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5804785042092112065L;
	protected String uuid;
    protected String fileName;
    protected String itemName;
    protected String itemType;
    
	public DocumentMetaDataVO(String fileName, String itemName, String itemType) {
		super();
		this.uuid = UUID.randomUUID().toString();
		this.fileName = fileName;
		this.itemName = itemName;
		this.itemType = itemType;
	}

	public DocumentMetaDataVO(String uuid, String fileName, String itemName, String itemType) {
		super();
		this.uuid = uuid;
		this.fileName = fileName;
		this.itemName = itemName;
		this.itemType = itemType;
	}


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Override
	public String toString() {
		return "DocumentMetaDataVO [uuid=" + uuid + ", fileName=" + fileName + ", itemName=" + itemName + ", itemType="
				+ itemType + "]";
	}
}
