package kh.semi.dto;

import java.sql.Date;

public class NoticeDTO 
{
	private int no_seq;
	private String no_writer;
	private String title;
    private String no_contents;
    private Date no_time;
	
    public NoticeDTO() 
    {
		super();
	}

	public NoticeDTO(int no_seq, String no_writer, String title, Date no_time)
	{
		super();
		this.no_seq = no_seq;
		this.no_writer = no_writer;
		this.title = title;
		this.no_time = no_time;
	}

	public NoticeDTO(int no_seq, String no_writer, String title, String no_contents, Date no_time)
	{
		super();
		this.no_seq = no_seq;
		this.no_writer = no_writer;
		this.title = title;
		this.no_contents = no_contents;
		this.no_time = no_time;
	}

	public int getNo_seq()
	{
		return no_seq;
	}

	public void setNo_seq(int no_seq)
	{
		this.no_seq = no_seq;
	}

	public String getNo_writer()
	{
		return no_writer;
	}

	public void setNo_writer(String no_writer)
	{
		this.no_writer = no_writer;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getNo_contents()
	{
		return no_contents;
	}

	public void setNo_contents(String no_contents)
	{
		this.no_contents = no_contents;
	}

	public Date getNo_time()
	{
		return no_time;
	}

	public void setNo_time(Date no_time)
	{
		this.no_time = no_time;
	}
    
}
