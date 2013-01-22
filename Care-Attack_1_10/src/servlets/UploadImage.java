package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.MySQLController;

/**
 * Servlet implementation class UploadImage
 */
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(processFileForm(request) != null)
		{
			response.getWriter().println("<script>alert('Sucess at file upload!')</script>");
		}
		else
		{
			response.getWriter().println("<script>alert('Something went wrong =( ')</script>");
		}
	}
	
	public ArrayList<String> processFileForm(HttpServletRequest request)
	{
		ArrayList<String> arrList = new ArrayList<String>();
		System.out.println("In Method processFileForm!");
		boolean success = false;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			System.out.println("In if(isMultiPart)");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			System.out.println("Request :  " + request);
			System.out.println("Request End! ");
			List<?> items;
			try {
				System.out.println("In try for processFileForm");
				items = upload.parseRequest(request);
				Iterator<?> iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					if(item.isFormField())
					{
						System.out.println("We're in item.isFormField()");
						String name = item.getFieldName();
					    String value = item.getString();
					    arrList.add(value);
					    System.out.println("Name of Field : " + name);
					    System.out.println("Value of Field : " + value);
					}
					else if (!item.isFormField()) {
						System.out.println("We're in !tem.isFormField()");
						String fileName = item.getName();
						System.out.println("File Name of uploaded file : "
								+ fileName);
						success = uploadFile(item, fileName);
					}
				}
			} catch (FileUploadException e) {
				System.out.println("================================");
				System.out.println("Start of FileUploadException details");
				e.printStackTrace();
				System.out.println("End of FileUploadException");
				System.out.println("===================================");
			}catch(SQLException sqlErr)
			{
				System.out.println("Theres an error with the SQL Query");
				sqlErr.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		return arrList;
	}

	/**
	 * Processes uploaded file and writes file out to server and filename to Database
	 * 
	 * This method uploadFile processes the FileItem parsed from
	 * the request and the file name and uses both to output the file out
	 * to the server through the file path specified and returns true if
	 * success and false for failure.
	 * This method will call upon uploadFileDataToDB
	 * @param item (FileItem)
	 * @param fileName (String)
	 * @return success 
	 * @throws FileUploadException
	 * @throws IOException
	 * @throws SQLException
	 */
	private boolean uploadFile(FileItem item, String fileName) throws FileUploadException,IOException,SQLException {
		System.out.println("In Method uploadFile!");
		boolean success = false;
			// String root = getServletContext().getRealPath("/");
			// Note that for File path, please replace the path name
			// in the constructor with the path of your directory
			// Note that it is temporary until a soln is found.
		try{
			System.out.println("In try for uploadFile");
			File path = new File("/Users/macpro/Documents/IT2299_JEDEVPJ/Care-Attack/Care-Attack_1_10/WebContent/images");
			File uploadedFile = new File(path + "/" + fileName);
			System.out.println("path of uploaded file : "
					+ uploadedFile.getAbsolutePath());
			if (path.exists()) {
				item.write(uploadedFile);
			} else {
				path.mkdirs();
				item.write(uploadedFile);
			}
			success =uploadFileDataToDB(fileName); 
			}catch(Exception e)
			{
				System.out.println("Something went wrong :(");
				e.printStackTrace();
			}
		return success;
	}
	
	/**
	 * Takes the file name and inserts a record into the database table
	 * 
	 * @param fileName (String)
	 * @return success (boolean)
	 * @throws SQLException
	 * @author Aaron Goy Ding Xian
	 */
	private boolean uploadFileDataToDB(String fileName) throws SQLException {
		MySQLController mysql = new MySQLController();
		mysql.setUp();
		String dbQuery = "INSERT INTO image(imagePath)";
		dbQuery += "VALUES('" + fileName + "')";
		boolean success = false;
		int result = mysql.updateRequest(dbQuery);
		if(result == 1)
		{
			success = true;
		}
		return success;
	}

	// FIXME
	public void getCurrentProgress() {
		// Create a progress listener
		@SuppressWarnings("unused")
		ProgressListener progressListener = new ProgressListener() {
			public void update(long pBytesRead, long pContentLength, int pItems) {
				System.out.println("We are currently reading item " + pItems);
				if (pContentLength == -1) {
					System.out.println("So far, " + pBytesRead
							+ " bytes have been read.");
				} else {
					System.out.println("So far, " + pBytesRead + " of "
							+ pContentLength + " bytes have been read.");
				}
			}
		};
	}

	// Sample of how the upload image should be in html/jsp
	// <form name="uploadForm" id="uploadForm" method="POST"
	// action="UploadImage" enctype="multipart/form-data">
	// <input type="file" value="sy" name="sy"></input> <input
	// type="submit" />
	// </form>
}
