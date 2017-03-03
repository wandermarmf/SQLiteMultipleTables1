package br.ufms.facom.model;

import java.util.ArrayList;

public class Todo
{
	
	private int id;
	private String note;
	private int status;
	private String created_at;
	private ArrayList<Tag> listTags;

	public Todo()
	{
		this.listTags = new ArrayList<Tag>();
	}

	public Todo(String note, int status)
	{
		this.note = note;
		this.status = status;
		this.listTags = new ArrayList<Tag>();
	}
	
	public Todo(int id, String note, int status)
	{
		this.id = id;
		this.note = note;
		this.status = status;
	}
	
	// setters
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setNote(String note)
	{
		this.note = note;
	}
	
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public void setCreatedAt(String created_at)
	{
		this.created_at = created_at;
	}

	// getters
	public String getCreateAt()
	{
		return this.created_at;
	}
	
	public long getId()
	{
		return this.id;
	}

	public String getNote()
	{
		return this.note;
	}
	
	public int getStatus()
	{
		return this.status;
	}

	public String getStatusDesc() {
        return StatusList.getStatusDesc(this.status);
	}

	public String getTagDesc() {
		String tags = "importante, ";

		for (Tag tag : listTags)
		{
			tags = tags + tag.getTagName() + ", ";
		}

		if (tags != "") {
			tags = tags.substring(1, tags.length() - 2);
		} else {
			tags = "sem categoria";
		}


		return tags;
	}

	public void addTag(Tag tag) {
		listTags.add(tag);
	}

	public void deleteTag(Tag tag) {
		int idx = listTags.indexOf(tag);

		if (idx > -1) {
			listTags.remove(idx);
		}

	}
}
